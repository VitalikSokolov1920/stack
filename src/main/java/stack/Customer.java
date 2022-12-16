package stack;

import com.opencsv.bean.CsvBindByPosition;

public class Customer implements CSVObject{
    @CsvBindByPosition(position = 0)
    private String id;
    @CsvBindByPosition(position = 1)
    private String lastName;
    @CsvBindByPosition(position = 2)
    private String street;
    @CsvBindByPosition(position = 3)
    private int houseNumber;
    @CsvBindByPosition(position = 4)
    private int apartmentNumber;
    @CsvBindByPosition(position = 5)
    private int calculationType;
    @CsvBindByPosition(position = 6)
    private int previousState;
    @CsvBindByPosition(position = 7)
    private int currentState;
    @CsvBindByPosition(position = 8, required = false)
    private double accruals;
    private static final double standard = 301.25;
    private static final double waterMeter = 1.52;

    public String[] toCSV() {
        String[] paths = new String[9];

        paths[0] = this.id;
        paths[1] = this.lastName;
        paths[2] = this.street;
        paths[3] = String.valueOf(this.houseNumber);
        paths[4] = String.valueOf(this.apartmentNumber);
        paths[5] = String.valueOf(this.calculationType);
        paths[6] = String.valueOf(this.previousState);
        paths[7] = String.valueOf(this.currentState);
        paths[8] = String.format("%.3f", this.accruals);

        return paths;
    }

    public void calculateAccruals() {
        if (this.calculationType == 1) {
            this.accruals = standard;
        } else if (this.calculationType == 2) {
            this.accruals = (this.currentState - this.previousState) * waterMeter;
        }
    }

    public String getStreet() {
        return street;
    }

    public double getAccruals() {
        return accruals;
    }

    public int getHouseNumber() {
        return houseNumber;
    }
}
