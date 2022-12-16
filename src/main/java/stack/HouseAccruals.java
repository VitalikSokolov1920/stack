package stack;

import com.opencsv.bean.CsvBindByName;

public class HouseAccruals implements CSVObject{
    private static int olderId = 1;
    @CsvBindByName(column = "№ строки")
    private int id;
    @CsvBindByName(column = "Улица")
    private String street;
    @CsvBindByName(column = "№ дома")
    private int houseNumber;
    @CsvBindByName(column = "Начислено", required = false)
    private double accruals;

    public String[] toCSV() {
        String[] paths = new String[4];

        paths[0] = String.valueOf(this.id);
        paths[1] = String.valueOf(this.street);
        paths[2] = String.valueOf(this.houseNumber);
        paths[3] = String.format("%.3f", this.accruals);

        return paths;
    }

    public HouseAccruals(String street, int houseNumber, double accruals) {
        this.id = olderId++;
        this.street = street;
        this.houseNumber = houseNumber;
        this.accruals = accruals;
    }
}
