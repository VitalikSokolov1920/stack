package stack;

import com.opencsv.CSVWriter;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

public class CustomerWriter {
    public static void writeCSVObjectList(File file, List<? extends CSVObject> customers) {
        try(CSVWriter writer = new CSVWriter(
                new FileWriter(file),
                ';',
                CSVWriter.NO_QUOTE_CHARACTER,
                CSVWriter.DEFAULT_ESCAPE_CHARACTER,
                CSVWriter.DEFAULT_LINE_END
        )) {
            List<String[]> strings = customers.stream()
                    .map(CSVObject::toCSV)
                    .collect(Collectors.toList());
            writer.writeAll(strings);
        }catch (IOException e) {
            e.printStackTrace();
        }
    }
}
