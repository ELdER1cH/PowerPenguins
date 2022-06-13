package pinguPinguEat.user;

import pinguPinguEat.reservationModel.Reservation;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
public class User {

    private String name;
    private List<Reservation> reservations;

    private UUID userID;

    public User(String name, String username) {
        this.name = name;
        this.reservations = new ArrayList<>();
    }

    public UUID getUserID() {
        return userID;
    }

    public String getName() {
        return name;
    }

    public List<Reservation> getReservations() {
        return reservations;
    }

    public boolean cancelReservation(Reservation reservation) {
        //TODO implement cancel Reservation
        return false;
    }

    public boolean makeReservation(Reservation reservation) {
        //TODO implement makeReservation
        return false;
    }

    public boolean confirmReservation(Reservation reservation) {
        return reservation.confirm();
    }
}
