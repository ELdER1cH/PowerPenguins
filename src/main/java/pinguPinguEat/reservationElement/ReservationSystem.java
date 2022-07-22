package pinguPinguEat.reservationElement;

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

    public HashMap<TimeSlot, List<Reservation>> getReservations() {
        return reservations;
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
        List<Reservation> currentRes = reservations.get(reservation.getTimeSlot());

        if (currentRes != null && !currentRes.isEmpty()) {
            currentRes.remove(reservation);
        }

        return true;
    }

    public boolean addReservation(Reservation reservation){
        List<Reservation> currentRes = reservations.get(reservation.getTimeSlot());

        if (currentRes == null || currentRes.isEmpty()) {
            List<Reservation> newRes = new ArrayList<>();
            newRes.add(reservation);
            reservations.put(reservation.getTimeSlot(), newRes);
        }
        else {
            currentRes.add(reservation);
        }

        return true;
    }

    public List<Table> getFreeTables(TimeSlot timeSlot){
        List<Table> freeTables = getTables();
        // TODO does this work for diff. timeslot objects of the same time?
        freeTables.removeIf(x -> reservations.get(timeSlot).contains(x));

        return freeTables;
    }
}
