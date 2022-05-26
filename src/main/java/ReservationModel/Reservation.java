package ReservationModel;

import java.time.Duration;
import java.time.Instant;
import java.time.LocalTime;

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
        //TODO cancel this Reservation
        return false;
    }

    public boolean confirm() {
        long twelveHoursInSeconds = 43200;
        long secondsUntilReservation = (Duration.between(LocalTime.now(),timeSlot.getStartTime()))
                                    .toSeconds();
        if (!this.isConfirmed() && secondsUntilReservation > twelveHoursInSeconds) {
            this.confirmed = true;
            return true;
        }
        else {
            return false;
        }
    }

    public boolean isConfirmed() {
        return confirmed;
    }
}
