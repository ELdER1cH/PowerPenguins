package pinguPinguEat.reservationModel;

public class Table {
    private final int tableNumber;
    private final int numberOfSeats;

    public Table(int tableNumber, int numberOfSeats) {
        this.tableNumber = tableNumber;
        this.numberOfSeats = numberOfSeats;
    }

    public int getTableNumber() {
        return tableNumber;
    }

    public int getNumberOfSeats() {
        return numberOfSeats;
    }
}
