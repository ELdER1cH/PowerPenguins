/**
 * Sample Skeleton for 'RestaurantGroupView.fxml' Controller Class
 */

package pinguPinguEat.view;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import pinguPinguEat.logic.ReviewLogic;
import pinguPinguEat.restaurants.Restaurant;
import pinguPinguEat.user.Review;
import pinguPinguEat.user.User;

import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

public class RestaurantGroupController {
    //My Variables
    public final ObservableList<Review> reviews = FXCollections.observableArrayList();
    public final ObservableList<ImageView> images = FXCollections.observableArrayList();
    public Dialog<Review> dialog;

    public ReviewLogic reviewLogic;


    //----------------------------------------------------------------------------------
    //My Functions
    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;
    @FXML // fx:id="imageList"
    private ListView<ImageView> imageList; // Value injected by FXMLLoader


    //----------------------------------------------------------------------------------
    //Generated Variables
    @FXML // fx:id="restaurantLinkLabel"
    private Label restaurantLinkLabel; // Value injected by FXMLLoader

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="ReviewList"
    private ListView<Review> ReviewList; // Value injected by FXMLLoader

    @FXML // fx:id="descriptionLabel"
    private Label descriptionLabel; // Value injected by FXMLLoader
    @FXML // fx:id="restaurantOpeningTimesLabel"
    private Label restaurantOpeningTimesLabel; // Value injected by FXMLLoader

    @FXML // fx:id="middleVBoxView"
    private VBox middleVBoxView; // Value injected by FXMLLoader

    @FXML // fx:id="restaurantExpensivnessLabel"
    private Label restaurantExpensivnessLabel; // Value injected by FXMLLoader

    /**
     * Updates all Labels in Restaurant
     *
     * @param restaurant
     */
    public void updateRestaurant(Restaurant restaurant) {
        this.restaurantNameLabel.setText(restaurant.getName());
        this.restaurantExpensivnessLabel.setText(restaurant.getPriceCategory().toString());
        this.restaurantRatingLabel.setText(String.valueOf(restaurant.getAverageRating()));
        this.restaurantTypeLabel.setText(restaurant.getCuisineType().toString());
        this.descriptionLabel.setText(restaurant.getDescription());
        this.reviews.addAll(restaurant.getReviews());
        this.ReviewList.setItems(reviews);
        this.restaurantLinkLabel.setText(restaurant.getLink());
        this.restaurantOpeningTimesLabel.setText(restaurant.getOpeningTimes());
        for (String image : restaurant.getImages()) {
            ImageView temp = new ImageView(image);
            temp.setFitWidth(250);
            temp.setPreserveRatio(true);
            temp.setSmooth(true);
            images.add(temp);
        }
        this.imageList.setItems(images);
    }

    @FXML // fx:id="restaurantNameLabel"
    private Label restaurantNameLabel; // Value injected by FXMLLoader

    private void showReviewDialog() {
        dialog = new Dialog<>();
        dialog.setTitle("Add Review");
        dialog.setHeaderText("Please Type in your Rating and Review");

        Label label1 = new Label("Rating: ");
        Label label2 = new Label("Review: ");
        TextField rating = new TextField();
        TextField review = new TextField();

        GridPane grid = new GridPane();
        grid.add(label1, 1, 1);
        grid.add(rating, 2, 1);
        grid.add(label2, 1, 2);
        grid.add(review, 2, 2);

        dialog.getDialogPane().setContent(grid);

        ButtonType buttonTypeOk = new ButtonType("Done", ButtonBar.ButtonData.OK_DONE);
        dialog.getDialogPane().getButtonTypes().add(buttonTypeOk);

        dialog.setResultConverter(param -> {
            if (param == buttonTypeOk) {
                int ratingInt;
                try {
                    ratingInt = Integer.parseInt(rating.getText());
                } catch (Exception e) {
                    ratingInt = 0;
                }
                if (ratingInt > 5) {
                    ratingInt = 5;
                }
                if (ratingInt < 0) {
                    ratingInt = 0;
                }
                //TODO Get Author from Somewhere
                return new Review(ratingInt, review.getText(), new User("Admin", "Test"));
            }
            return null;
        });


        Optional<Review> result = dialog.showAndWait();

        result.ifPresent(value -> reviewLogic.postReview(value));
    }

    @FXML // fx:id="restaurantRatingLabel"
    private Label restaurantRatingLabel; // Value injected by FXMLLoader

    @FXML // fx:id="restaurantTypeLabel"
    private Label restaurantTypeLabel; // Value injected by FXMLLoader

    @FXML // fx:id="submitReviewButton"
    private Button submitReviewButton; // Value injected by FXMLLoader

    @FXML // fx:id="toReservationButton"
    private Button toReservationButton; // Value injected by FXMLLoader

    @FXML
    void addReviewAction(ActionEvent event) {
        showReviewDialog();
    }

    @FXML
    void switchToRestaurantReservationView(ActionEvent event) {

    }

    @FXML
        // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert ReviewList != null : "fx:id=\"ReviewList\" was not injected: check your FXML file 'RestaurantGroupView.fxml'.";
        assert descriptionLabel != null : "fx:id=\"descriptionLabel\" was not injected: check your FXML file 'RestaurantGroupView.fxml'.";
        assert imageList != null : "fx:id=\"imageList\" was not injected: check your FXML file 'RestaurantGroupView.fxml'.";
        assert middleVBoxView != null : "fx:id=\"middleVBoxView\" was not injected: check your FXML file 'RestaurantGroupView.fxml'.";
        assert restaurantExpensivnessLabel != null : "fx:id=\"restaurantExpensivnessLabel\" was not injected: check your FXML file 'RestaurantGroupView.fxml'.";
        assert restaurantLinkLabel != null : "fx:id=\"restaurantLinkLabel\" was not injected: check your FXML file 'RestaurantGroupView.fxml'.";
        assert restaurantNameLabel != null : "fx:id=\"restaurantNameLabel\" was not injected: check your FXML file 'RestaurantGroupView.fxml'.";
        assert restaurantOpeningTimesLabel != null : "fx:id=\"restaurantOpeningTimesLabel\" was not injected: check your FXML file 'RestaurantGroupView.fxml'.";
        assert restaurantRatingLabel != null : "fx:id=\"restaurantRatingLabel\" was not injected: check your FXML file 'RestaurantGroupView.fxml'.";
        assert restaurantTypeLabel != null : "fx:id=\"restaurantTypeLabel\" was not injected: check your FXML file 'RestaurantGroupView.fxml'.";
        assert submitReviewButton != null : "fx:id=\"submitReviewButton\" was not injected: check your FXML file 'RestaurantGroupView.fxml'.";
        assert toReservationButton != null : "fx:id=\"toReservationButton\" was not injected: check your FXML file 'RestaurantGroupView.fxml'.";
        this.reviewLogic = new ReviewLogic(this);
    }




}
