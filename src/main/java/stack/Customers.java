package stack;

import java.util.List;
import java.util.stream.Collectors;

public class Customers{
    public static List<HouseAccruals> calculateAccrualsEachHouse(List<Customer> customers) {
        var houseMap = customers.stream().collect(
                Collectors.groupingBy(Customer::getHouseNumber));

        return houseMap.values().stream().map(customerList -> {
            double total_sum = customerList
                    .stream()
                    .map(Customer::getAccruals)
                    .reduce(0.0, Double::sum);
            Customer customer = customers.get(0);

            return new HouseAccruals(
                    customer.getStreet(),
                    customer.getHouseNumber(),
                    total_sum
            );
        }).collect(Collectors.toList());
    }
}
