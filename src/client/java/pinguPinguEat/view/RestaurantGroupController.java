/**
 * Sample Skeleton for 'RestaurantGroupView.fxml' Controller Class
 */

package pinguPinguEat.view;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import pinguPinguEat.restaurants.Restaurant;
import pinguPinguEat.user.Review;

import java.net.URL;
import java.util.ResourceBundle;

public class RestaurantGroupController {
    public final ObservableList<String> reviews = FXCollections.observableArrayList();
    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;
    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;
    @FXML // fx:id="ReservationList"
    private ListView<String> reviewList; // Value injected by FXMLLoader
    @FXML // fx:id="descriptionLabel"
    private Label descriptionLabel; // Value injected by FXMLLoader
    @FXML // fx:id="restaurantExpensivnessLabel"
    private Label restaurantExpensivnessLabel; // Value injected by FXMLLoader
    @FXML // fx:id="restaurantNameLabel"
    private Label restaurantNameLabel; // Value injected by FXMLLoader
    @FXML // fx:id="restaurantRatingLabel"
    private Label restaurantRatingLabel; // Value injected by FXMLLoader
    @FXML // fx:id="restaurantTypeLabel"
    private Label restaurantTypeLabel; // Value injected by FXMLLoader
    @FXML // fx:id="toMapButton"
    private Button toMapButton; // Value injected by FXMLLoader
    @FXML // fx:id="toReservationButton"
    private Button toReservationButton; // Value injected by FXMLLoader

    public void updateRestaurant(Restaurant restaurant) {
        this.restaurantNameLabel.setText(restaurant.getName());
        this.restaurantExpensivnessLabel.setText(restaurant.getPriceCategory().toString());
        this.restaurantRatingLabel.setText(String.valueOf(restaurant.getAverageRating()));
        this.restaurantTypeLabel.setText(restaurant.getCuisineType().toString());
        this.descriptionLabel.setText(restaurant.getDescription());
        this.reviews.addAll(restaurant.getReviews().stream().map(Review::toString).toList());
        this.reviewList.setItems(reviews);
    }

    @FXML
        // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert reviewList != null : "fx:id=\"ReservationList\" was not injected: check your FXML file 'RestaurantGroupView.fxml'.";
        assert descriptionLabel != null : "fx:id=\"descriptionLabel\" was not injected: check your FXML file 'RestaurantGroupView.fxml'.";
        assert restaurantExpensivnessLabel != null : "fx:id=\"restaurantExpensivnessLabel\" was not injected: check your FXML file 'RestaurantGroupView.fxml'.";
        assert restaurantNameLabel != null : "fx:id=\"restaurantNameLabel\" was not injected: check your FXML file 'RestaurantGroupView.fxml'.";
        assert restaurantRatingLabel != null : "fx:id=\"restaurantRatingLabel\" was not injected: check your FXML file 'RestaurantGroupView.fxml'.";
        assert restaurantTypeLabel != null : "fx:id=\"restaurantTypeLabel\" was not injected: check your FXML file 'RestaurantGroupView.fxml'.";
        assert toMapButton != null : "fx:id=\"toMapButton\" was not injected: check your FXML file 'RestaurantGroupView.fxml'.";
        assert toReservationButton != null : "fx:id=\"toReservationButton\" was not injected: check your FXML file 'RestaurantGroupView.fxml'.";

    }

}
