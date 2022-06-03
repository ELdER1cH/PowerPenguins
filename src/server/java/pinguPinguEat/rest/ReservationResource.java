package pinguPinguEat.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pinguPinguEat.reservationModel.Reservation;
import pinguPinguEat.service.ReservationService;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
public class ReservationResource {
    //initiert Reservation Service
    private final ReservationService reservationService;

    //Construktor
    public ReservationResource(ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    //Ruft saved die übergebene Reservierung über reservation Service
    @PostMapping("/reservations")
    public ResponseEntity<Reservation> createReservation(@RequestBody Reservation reservation){
        return ResponseEntity.ok(reservationService.saveReservation(reservation));
    }


    //Versucht die Reservierung zu confirmen,
    //Falls das nicht klappt, wegen Zeitbegrenzung oder weil die ID Falsch ist wird ein BadRequest zurückgegeben
    @PutMapping("/reservations/{reservationId}")
    public ResponseEntity<Boolean> confirmReservation(@PathVariable UUID reservationId){
        if (!reservationService.confirmReservation(reservationId)){
            return ResponseEntity.badRequest().build();
        }else {
            return ResponseEntity.ok(true);
        }
    }

    //Versucht die Reservierung zu canceln
    //Falls das nicht klappt, weil die ID nicht stimmt wird ein BadRequest zurückgegeben
    @DeleteMapping("/reservations/{reservatioID}")
    public ResponseEntity<HttpStatus> cancelReservation(@PathVariable UUID reservatioID){
        if (!reservationService.deleteReservation(reservatioID)){
            return ResponseEntity.badRequest().build();
        }else{
            return ResponseEntity.noContent().build();
        }
    }

    //vlt hier an der falschen Stelle, weil das ja eigentlich was vom USER ist
    @GetMapping("/reservation/{userID}")
    public ResponseEntity<List<Reservation>> getAllReservations(@PathVariable UUID userID){
        return ResponseEntity.ok(reservationService.getAllReservations(userID));
    }


}
