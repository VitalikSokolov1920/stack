package stack;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

public class CSVWriter {
    private final String[] header;

    public CSVWriter(String ...header) {
        this.header = header;
    }

    public void writeCSVObjectList(File file, List<? extends CSVObject> customers) {
        try(com.opencsv.CSVWriter writer = new com.opencsv.CSVWriter(
                new FileWriter(file),
                ';',
                com.opencsv.CSVWriter.NO_QUOTE_CHARACTER,
                com.opencsv.CSVWriter.DEFAULT_ESCAPE_CHARACTER,
                com.opencsv.CSVWriter.DEFAULT_LINE_END
        )) {
            if (this.header.length != 0) {
                writer.writeNext(this.header);
            }
            List<String[]> strings = customers.stream()
                    .map(CSVObject::toCSV)
                    .collect(Collectors.toList());
            writer.writeAll(strings);
        }catch (IOException e) {
            e.printStackTrace();
        }
    }
}
