package user;

import ReservationModel.Reservation;

import java.util.ArrayList;
import java.util.List;

public class User {
    private final String name;
    private final String username;
    private String password;
    private List<Reservation> reservations;

    public User(String name, String username, String password) {
        this.name = name;
        this.username = username;
        this.password = password;
        this.reservations = new ArrayList<>();
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
