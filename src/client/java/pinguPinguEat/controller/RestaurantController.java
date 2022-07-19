package pinguPinguEat.controller;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;
import pinguPinguEat.reservationElement.Reservation;
import pinguPinguEat.reservationElement.Table;
import pinguPinguEat.reservationElement.TimeSlot;
import pinguPinguEat.restaurantElement.Restaurant;

import java.util.HashMap;
import java.util.List;
import java.util.UUID;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class RestaurantController {
    private final WebClient webClient;

    // HashMap genutzt, um aud ID leicht zuzugreifen, aber problematisch im Code
    private final HashMap<UUID, Restaurant> restaurantHashMap;
    private final HashMap<Integer, Table> tableHashMap;

    public RestaurantController() {
        this.webClient = WebClient.builder()
                .baseUrl("http://localhost:8080/")
                .defaultHeader(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON_VALUE)
                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .build();
        this.restaurantHashMap = new HashMap<>();
        this.tableHashMap = new HashMap<>();
    }

    public void getAllRestaurants(Consumer<HashMap<UUID, Restaurant>> restaurantConsumer) {
        webClient.get()
                .uri(uriBuilder -> uriBuilder
                        .path("/restaurants")
                        .build())
                .retrieve()
                .bodyToMono(new ParameterizedTypeReference<List<Restaurant>>() {
                })
                .onErrorStop()
                .subscribe(newRestaurants -> {
                    restaurantHashMap.clear();
                    restaurantHashMap.putAll(newRestaurants.stream().collect(Collectors.toMap(Restaurant::getRestaurantID, r -> r)));
                    restaurantConsumer.accept(restaurantHashMap);
                });
    }

    public void getRestaurant(Consumer<Restaurant> restaurantConsumer, UUID restaurantID) {
        webClient.get()
                .uri(uriBuilder -> uriBuilder
                        .path("/restaurants")
                        .build())
                .retrieve()
                .bodyToMono(new ParameterizedTypeReference<List<Restaurant>>() {
                })
                .onErrorStop()
                .subscribe(newRestaurants -> {
                    restaurantHashMap.clear();
                    restaurantHashMap.putAll(newRestaurants.stream().collect(Collectors.toMap(Restaurant::getRestaurantID, r -> r)));
                    restaurantConsumer.accept(restaurantHashMap.get(restaurantID));

                });
    }
    public void getAllTables(Consumer<List<Table>> tableConsumer, UUID restaurantID) {
        webClient.get()
                .uri(uriBuilder -> uriBuilder
                        .path("/restaurants/" + restaurantID)
                        .build())
                .retrieve()
                .bodyToMono(new ParameterizedTypeReference<List<Table>>() {
                })
                .onErrorStop()
                .subscribe(newTables -> {
                    tableHashMap.clear();
                    tableHashMap.putAll(newTables.stream().collect(Collectors.toMap(Table::getTableNumber, r -> r)));
                    //TODO Update
                    tableConsumer.accept(restaurantHashMap.get(restaurantID).getReservationSystem().getTables());
                });
    }

    public void getFreeTables(Consumer<List<Table>> tableConsumer, UUID restaurantID, TimeSlot timeSlot) {
        List<Table> allTables = restaurantHashMap.get(restaurantID).getReservationSystem().getTables();
        List<Reservation> reservations = restaurantHashMap.get(restaurantID).getReservationSystem().getReservations().get(timeSlot);
        for (Reservation reservation : reservations) {
            if (allTables.contains(reservation.getTable())) {
                reservation = null;
            }
        }

        webClient.get()
                .uri(uriBuilder -> uriBuilder
                        .path("/restaurants/" + restaurantID)
                        .build())
                .retrieve()
                .bodyToMono(new ParameterizedTypeReference<List<Table>>() {
                })
                .onErrorStop()
                .subscribe(newRestaurants -> {
                    restaurantHashMap.clear();
                    //TODO Return Value to List
                    tableConsumer.accept(allTables.stream().filter(x -> x != null).collect(Collectors.toList()));
                });
    }

}
