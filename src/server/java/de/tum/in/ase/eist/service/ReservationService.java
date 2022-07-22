package de.tum.in.ase.eist.service;

import org.springframework.stereotype.Service;
import pinguPinguEat.reservationElement.Reservation;

import java.util.HashMap;
import java.util.List;
import java.util.UUID;

@Service
public class ReservationService {
    //
    private final HashMap<UUID, Reservation> reservations;

    public ReservationService() {
        reservations = new HashMap<>();
    }

    public Reservation saveReservation(Reservation reservation) {
        reservation.setReservationId(UUID.randomUUID());
        return reservations.put(reservation.getReservationId(), reservation);
    }

    public boolean confirmReservation(UUID reservationID) {
        //TODO implement mit access zur Database
        return reservations.get(reservationID).confirm();
    }

    public boolean deleteReservation(UUID reservationID){
        //TODO implement mit access zur Database
        return reservations.remove(reservationID) != null;
    }

    public List<Reservation> getAllReservations(UUID userID){
        //TODO implement mit access zur Database
        return null;
    }
}
