package stack;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        File input = new File("src//main//resources//data//абоненты.csv");
        File outputCustomers = new File("src//main//resources//output//Начисления_абоненты.csv");
        File outputHouses = new File("src//main//resources//output//Начисления_дома.csv");

        try {
            List<Customer> customers = CustomerReader.readCustomers(input);

            customers.forEach(Customer::calculateAccruals);

            CSVWriter customersWriter = new CSVWriter(
                    "№ строки",
                    "Фамилия",
                    "Улица",
                    "№ дома",
                    "№ Квартиры",
                    "Тип начисления",
                    "Предыдущее",
                    "Текущее",
                    "Начислено"
            );

            customersWriter.writeCSVObjectList(outputCustomers, customers);

            List<HouseAccruals> houseAccruals = Customers.calculateAccrualsEachHouse(customers);

            CSVWriter housesWriter = new CSVWriter(
                "№ строки",
                    "Улица",
                    "№ дома",
                    "Начислено"
            );

            housesWriter.writeCSVObjectList(outputHouses, houseAccruals);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}