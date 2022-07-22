package pinguPinguEat.controller;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;
import pinguPinguEat.reservationElement.Reservation;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class ReservationController {
    private final WebClient webClient;
    private final List<Reservation> reservationsList;

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
                .uri("/reservations")
                .bodyValue(reservation)
                .retrieve()
                .bodyToMono(Reservation.class)
                .onErrorStop()
                .subscribe(newReservation -> reservationsList.add(newReservation));
    }

    public void confirmReservation(Reservation reservation) {
        webClient.put()
                .uri("/reservations/" + reservation.getReservationId())
                .retrieve()
                .bodyToMono(Reservation.class)
                .onErrorStop()
                .subscribe(newReservation -> reservationsList.replaceAll(
                        oldReservation ->
                                oldReservation.getReservationId().equals(newReservation.getReservationId()) ?
                                newReservation : oldReservation));
    }

    public void cancelReservation(Reservation reservation) {
        webClient.delete()
                .uri("/reservations/" + reservation.getReservationId())
                .retrieve()
                .toBodilessEntity()
                .onErrorStop()
                .subscribe(v -> reservationsList.remove(reservation));
    }

    public void getAllReservations(Consumer<List<Reservation>> restaurantConsumer) {
        webClient.get()
                .uri(uriBuilder -> uriBuilder
                        .path("/reservations")
                        .build())
                .retrieve()
                .bodyToMono(new ParameterizedTypeReference<List<Reservation>>() {
                })
                .onErrorStop()
                .subscribe(newRestaurants -> {
                    reservationsList.clear();
                    reservationsList.addAll(newRestaurants.stream().collect(Collectors.toList()));
                    restaurantConsumer.accept(reservationsList);
                });
    }
}
