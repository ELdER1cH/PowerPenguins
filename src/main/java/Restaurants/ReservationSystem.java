package Restaurants;

import User.Reservation;
import User.TimeSlot;

import java.util.HashMap;
import java.util.List;

public class ReservationSystem {
    private int numberOfSeats;
    private int numberOfTables;
    private HashMap<Integer,Table> tables;
    private int tablesindex;
    private HashMap<TimeSlot, List<Reservation>> reservations;

    public ReservationSystem(int numberOfSeats, int numberOfTables) {
        this.numberOfSeats = numberOfSeats;
        this.numberOfTables = numberOfTables;
        this.tablesindex = 0;
        this.tables = new HashMap<>();
        this.reservations = new HashMap<>();
    }

    public void addTable(int numberOfSeats){
        Table temp = new Table(tablesindex++, numberOfSeats);
        this.numberOfSeats += numberOfSeats;
        this.numberOfTables++;
        tables.put(temp.getTableNumber(),temp);
    }

    public int getNumberOfSeats() {
        return numberOfSeats;
    }

    public int getNumberOfTables() {
        return numberOfTables;
    }

    public HashMap<Integer, Table> getTables() {
        return tables;
    }

    public void setNumberOfSeats(int numberOfSeats) {
        this.numberOfSeats = numberOfSeats;
    }

    public void setNumberOfTables(int numberOfTables) {
        this.numberOfTables = numberOfTables;
    }

    public boolean cancelReservation(Reservation reservation){
        //TODO implement
        return false;
    }

    public boolean addReservation(Reservation reservation){
        //TODO implement
        return false;
    }

    public List<Table> getFreeTables(TimeSlot timeSlot){
        //TODO implement
        return null;
    }
}
