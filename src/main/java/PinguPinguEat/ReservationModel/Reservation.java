package PinguPinguEat.ReservationModel;

import PinguPinguEat.restaurants.Restaurant;

import java.time.Duration;
import java.time.LocalTime;
import java.util.UUID;

public class Reservation {
    private final TimeSlot timeSlot;
    private final Table table;
    private final Restaurant restaurant;
    private boolean confirmed;
    private UUID reservationId;


    public Reservation(TimeSlot timeSlot, Table table, Restaurant restaurant) {
        this.timeSlot = timeSlot;
        this.table = table;
        this.restaurant = restaurant;
        this.confirmed = false;
    }

    public boolean cancelReservation(){
        //TODO cancel this Reservation
        return false;
    }

    public boolean confirm() {
        // this has to be in seconds, so you can still confirm let's say 12:10:13 before the reservation
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

    public TimeSlot getTimeSlot() {
        return timeSlot;
    }

    public Table getTable() {
        return table;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public UUID getReservationId() {
        return reservationId;
    }

    public void setConfirmed(boolean confirmed) {
        this.confirmed = confirmed;
    }

    public void setReservationId(UUID reservationId) {
        this.reservationId = reservationId;
    }

    public boolean isConfirmed() {
        return confirmed;
    }
}
