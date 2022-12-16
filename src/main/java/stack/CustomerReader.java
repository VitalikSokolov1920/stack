package stack;

import com.opencsv.bean.CsvToBeanBuilder;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;

public class CustomerReader {

    public static List<Customer> readCustomers(File file) throws FileNotFoundException {

        return new CsvToBeanBuilder<Customer>(new FileReader(file))
                .withType(Customer.class)
                .withIgnoreEmptyLine(true)
                .withSkipLines(1)
                .withSeparator(';')
                .build()
                .parse();
    }
}
