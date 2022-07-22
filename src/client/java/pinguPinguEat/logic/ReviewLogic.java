package pinguPinguEat.logic;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import pinguPinguEat.controller.ReviewController;
import pinguPinguEat.restaurantElement.Restaurant;
import pinguPinguEat.userElement.Review;
import pinguPinguEat.view.RestaurantGroupView;

import java.util.List;

public class ReviewLogic {
    private final ObservableList<Review> reviewObservableList;

    private final ReviewController reviewController;

    private final RestaurantGroupView restaurantGroupView;

    public ReviewLogic(RestaurantGroupView restaurantGroupView) {
        this.reviewObservableList = FXCollections.observableArrayList();
        this.reviewController = new ReviewController();
        this.restaurantGroupView = restaurantGroupView;
        this.reviewController.getAllReviews(this::setReview);
    }

    /**
     * Should send Review to Server
     * Currently just adding it back to Restaurant View
     *
     * @param review
     */
    public void postReview(Review review, Restaurant currentRestaurant) {
        reviewController.addReview(review, reviews -> {
            restaurantGroupView.reviews.clear();
            restaurantGroupView.reviews.addAll(reviews);
        });
        restaurantGroupView.reviews.add(review);
        currentRestaurant.addReview(review);
    }

    //    delete
    public void deleteReview() {

    }

    //    Initial View of reviews for a restaurant profile
    public void showFiveReviewsAsInitialView() {

    }

    //    show all reviews
    public void showAllReviews() {

    }

    private void setReview(List<Review> review) {
        Platform.runLater(() -> reviewObservableList.setAll(review));
    }
}
