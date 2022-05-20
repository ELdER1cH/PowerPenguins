package user;


import restaurants.ReservationSystem;
import restaurants.Table;


public class Reservation {
    private TimeSlot timeSlot;
    private Table table;
    private ReservationSystem reservationSystem;

    public Reservation(TimeSlot timeSlot, Table table, ReservationSystem reservationSystem) {
        this.timeSlot = timeSlot;
        this.table = table;
        this.reservationSystem = reservationSystem;
    }

    boolean cancelReservation(){
        //TODO implement
        return false;
    }
}
