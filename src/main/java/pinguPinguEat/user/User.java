package pinguPinguEat.user;

import pinguPinguEat.reservationModel.Reservation;

import java.util.ArrayList;
import java.util.List;

public class User {
    private final String name;
    private final List<Reservation> reservations;

    public User(String name, String username, String password) {
        this.name = name;
        this.reservations = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public List<Reservation> getReservations() {
        return reservations;
    }

    public boolean cancelReservation(Reservation reservation){
        //TODO implement cancel Reservation
        return false;
    }

    public boolean makeReservation(Reservation reservation){
        //TODO implement makeReservation
        return false;
    }

    public boolean confirmReservation(Reservation reservation){
        return reservation.confirm();
    }
}
