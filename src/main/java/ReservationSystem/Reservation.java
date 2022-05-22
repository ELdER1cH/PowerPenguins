package ReservationSystem;


public class Reservation {
    private TimeSlot timeSlot;
    private Table table;
    private ReservationSystem reservationSystem;

    public Reservation(TimeSlot timeSlot, Table table, ReservationSystem reservationSystem) {
        this.timeSlot = timeSlot;
        this.table = table;
        this.reservationSystem = reservationSystem;
    }

    public boolean cancelReservation(){
        //TODO cancelthisReservation
        return false;
    }
}
