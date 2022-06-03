package pinguPinguEat.controller;

import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;
import pinguPinguEat.reservationModel.Reservation;

import java.util.ArrayList;
import java.util.List;

public class ReservationController {
    WebClient webClient;
    List<Reservation> reservationsList;

    public ReservationController() {
        this.reservationsList = new ArrayList<>();
        this.webClient = WebClient.builder()
                .baseUrl("http://localhost:8080/")
                .defaultHeader(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON_VALUE)
                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .build();
    }

    public void addReservation(Reservation reservation) {
        webClient.post()
                .uri("/reservatoion")
                .bodyValue(reservation)
                .retrieve()
                .bodyToMono(Reservation.class)
                .onErrorStop()
                .subscribe(newPerson -> reservationsList.add(newPerson));
    }

    public void confirmReservation(Reservation reservation) {
        webClient.put()
                .uri("/persons" + reservation.getReservationId())
                .retrieve()
                .bodyToMono(Reservation.class)
                .onErrorStop()
                .subscribe(newReservation -> reservationsList.replaceAll(oldReservation -> oldReservation.getReservationId().equals(newReservation.getReservationId()) ? newReservation : oldReservation));
    }

    public void cancelReservation(Reservation reservation) {
        webClient.delete()
                .uri("/persons/" + reservation.getReservationId())
                .retrieve()
                .toBodilessEntity()
                .onErrorStop()
                .subscribe(v -> reservationsList.remove(reservation));
    }
}
