package ReservationModel;


import java.time.Duration;
import java.time.Instant;

public class Reservation {
    private TimeSlot timeSlot;
    private Table table;
    private ReservationSystem reservationSystem;
    private boolean confirmed;

    public Reservation(TimeSlot timeSlot, Table table, ReservationSystem reservationSystem) {
        this.timeSlot = timeSlot;
        this.table = table;
        this.reservationSystem = reservationSystem;
        this.confirmed = false;
    }

    public boolean cancelReservation(){
        //TODO cancelthisReservation
        return false;
    }

    public boolean isConfirmed() {
        return confirmed;
    }

    public boolean confirm() {
        if (!this.confirmed && Duration.between(Instant.now(),timeSlot.getStartTime().toInstant()).toHours() > 12){
            this.confirmed = true;
            return true;
        }else{
            return false;
        }


    }
}
