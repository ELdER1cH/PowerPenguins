package PinguPinguEat.service;

import PinguPinguEat.ReservationModel.Reservation;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ReservationService {

    public Reservation saveReservation(Reservation reservation){
        //TODO implement mit access zur Database
        return reservation;
    }

    public boolean confirmReservation(UUID reservationID){
        //TODO implement mit access zur Database
        return false;
    }

    public boolean deleteReservation(UUID reservationID){
        //TODO implement mit access zur Database
        return false;
    }

    public List<Reservation> getAllReservations(UUID userID){
        //TODO implement mit access zur Database
        return null;
    }
}
