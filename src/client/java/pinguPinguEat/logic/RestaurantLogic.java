package pinguPinguEat.logic;

import pinguPinguEat.reservationModel.ReservationSystem;
import pinguPinguEat.restaurants.CuisineType;
import pinguPinguEat.restaurants.PriceCategory;
import pinguPinguEat.restaurants.Restaurant;

import java.util.ArrayList;
import java.util.List;

public class RestaurantLogic {
    public static List<Restaurant> getAllRestaurants() {
        List<Restaurant> returnValue = new ArrayList<>();
        returnValue.add(new Restaurant("Test", CuisineType.GERMAN, PriceCategory.INEXPENSIVE, "Test 1", new ReservationSystem(0, 0)));
        returnValue.add(new Restaurant("Lorem Ipsum", CuisineType.GERMAN, PriceCategory.INEXPENSIVE, "Test 2", new ReservationSystem(0, 0)));
        return returnValue;
    }
}
