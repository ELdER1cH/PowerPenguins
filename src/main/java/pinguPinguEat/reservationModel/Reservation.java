package pinguPinguEat.reservationModel;

import pinguPinguEat.restaurants.Restaurant;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
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
        if (this.isConfirmable()) {
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

    public boolean isConfirmable() {
        // this has to be in seconds, so you can still confirm let's say 12:10:13 before the reservation
        long twelveHoursInSeconds = 43200;
        long secondsUntilReservation = Math.abs((Duration.between(LocalDateTime.now(), timeSlot.getStartTime()))
                .toSeconds());
        return !this.isConfirmed() && secondsUntilReservation < twelveHoursInSeconds;
    }

    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
        return restaurant.getName() + " on " + timeSlot.getStartTime().format(DateTimeFormatter.ofPattern("dd.MM.YY")) + " at " +
                timeSlot.getStartTime().format(formatter) + "\t[" + (confirmed? "confirmed" : "not confirmed") + "]";
    }
}
