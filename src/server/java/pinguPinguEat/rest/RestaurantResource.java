package pinguPinguEat.rest;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pinguPinguEat.reservationModel.Table;
import pinguPinguEat.reservationModel.TimeSlot;
import pinguPinguEat.restaurants.Restaurant;
import pinguPinguEat.service.RestaurantService;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
public class RestaurantResource {

    private final RestaurantService restaurantService;

    public RestaurantResource(RestaurantService restaurantService) {
        this.restaurantService = restaurantService;
    }

    public RestaurantResource() {
        this.restaurantService = new RestaurantService();
    }

    @GetMapping("/restaurant")
    public ResponseEntity<List<Restaurant>> getAllRestaurants(/*Filter filter*/) {
        return ResponseEntity.ok(restaurantService.getAllRestaurants(/*Filter filter*/));
    }

    @GetMapping("/restaurant/{restaurantID}")
    public ResponseEntity<Restaurant> getRestaurant(@PathVariable UUID restaurantID) {
        return ResponseEntity.ok(restaurantService.getRestaurant(restaurantID));
    }

    @GetMapping("/restaurant/{restaurantID}/{timeSlot}")
    public ResponseEntity<List<Table>> getFreeTables(@PathVariable UUID restaurantID, @PathVariable TimeSlot timeSlot) {
        return ResponseEntity.ok(restaurantService.getFreeTables(restaurantID, timeSlot));
    }

    @GetMapping("/restaurant/{restaurantID}")
    public ResponseEntity<List<Table>> getAllTables(@PathVariable UUID restaurantID) {
        return ResponseEntity.ok(restaurantService.getAllTables(restaurantID));
    }
}

