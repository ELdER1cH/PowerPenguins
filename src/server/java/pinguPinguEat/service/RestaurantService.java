package pinguPinguEat.service;

import pinguPinguEat.reservationModel.Reservation;
import pinguPinguEat.reservationModel.Table;
import pinguPinguEat.reservationModel.TimeSlot;
import pinguPinguEat.restaurants.Restaurant;

import java.util.HashMap;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

public class RestaurantService {
    private final HashMap<UUID, Restaurant> restaurants;

    public RestaurantService() {
        restaurants = new HashMap<UUID, Restaurant>();
    }

    // return Restaurant of corresponding restaurantID
    public Restaurant getRestaurant(UUID restaurantID) {
        return restaurants.get(restaurantID);
    }

    public List<Restaurant> getAllRestaurants(/*Filter filter*/) {
        //TODO implement mit access zur Database
        return null;
    }

    public List<Table> getFreeTables(UUID restaurantID, TimeSlot timeSlot) {
        List<Table> allTables = getAllTables(restaurantID);
        List<Reservation> reservations = restaurants.get(restaurantID).getReservationSystem().getReservations().get(timeSlot);
        for (Reservation reservation : reservations) {
            if (allTables.contains(reservation.getTable())) {
                reservation = null;
            }
        }
        return allTables.stream().filter(x -> x != null).collect(Collectors.toList());
    }

    public List<Table> getAllTables(UUID restaurantID) {
        return restaurants.get(restaurantID).getReservationSystem().getTables();
    }


}
