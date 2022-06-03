package pinguPinguEat.reservationModel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ReservationSystem {
    private int numberOfSeats;
    private int numberOfTables;
    private final List<Table> tables;
    private final HashMap<TimeSlot, List<Reservation>> reservations;

    public ReservationSystem(int numberOfSeats, int numberOfTables) {
        this.numberOfSeats = numberOfSeats;
        this.numberOfTables = numberOfTables;
        this.tables = new ArrayList<>();
        this.reservations = new HashMap<>();
    }

    public void addTable(int numberOfSeats) {
        Table temp = new Table(tables.toArray().length, numberOfSeats);
        this.numberOfSeats += numberOfSeats;
        this.numberOfTables++;
        this.tables.add(temp);
    }

    public int getNumberOfSeats() {
        return numberOfSeats;
    }

    public int getNumberOfTables() {
        return numberOfTables;
    }

    public List<Table> getTables() {
        return tables;
    }

    public void setNumberOfSeats(int numberOfSeats) {
        this.numberOfSeats = numberOfSeats;
    }

    public void setNumberOfTables(int numberOfTables) {
        this.numberOfTables = numberOfTables;
    }

    public boolean deleteReservation(Reservation reservation){
        //TODO implement deleteReservation
        return false;
    }

    public boolean addReservation(Reservation reservation){
        //TODO implement addReservation
        return false;
    }

    public List<Table> getFreeTables(TimeSlot timeSlot){
        //TODO implement getFreeTables
        return null;
    }
}
