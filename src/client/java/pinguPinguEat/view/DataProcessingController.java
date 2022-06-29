package pinguPinguEat.view;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableMap;
import javafx.event.ActionEvent;
import pinguPinguEat.controller.ReservationController;
import pinguPinguEat.controller.RestaurantController;
import pinguPinguEat.controller.ReviewController;
import pinguPinguEat.restaurants.Restaurant;

import java.util.Map;
import java.util.UUID;

public class DataProcessingController {

    private final ObservableMap<UUID, Restaurant> restaurantObservableMap;
    private SceneController sceneController;
    private ReservationController reservationController;
    private RestaurantController restaurantController;
    private ReviewController reviewController;

    public DataProcessingController() {
        this.sceneController = new SceneController();
        this.reservationController = new ReservationController();
        this.restaurantController = new RestaurantController();
        this.reviewController = new ReviewController();
        this.restaurantObservableMap = FXCollections.observableMap(restaurantController.getRestaurantHashMap());

    }

    // "on action" method for "search" button
    // Take the text from searchField in Class SceneController
    // Then, use String.contains() for the name and cuisineType of restaurants.
    public void searchRestuarant(ActionEvent event) {
        String searchCondition = sceneController.getSearchField().getText();

    }

    // "on action" method for "sort" button
    // according to different attributes and the orders, ascending or descending.
    //attribute : price

    //attribute : averageRating


    //  "on action" method for "filter" button
    //  according to the provided conditions to filter attributes of objects


    private void setRestaurant(Map<UUID, Restaurant> restaurant) {
        Platform.runLater(() -> restaurantObservableMap.putAll(restaurant));
    }
}
