package pinguPinguEat.logic;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import pinguPinguEat.controller.ReviewController;
import pinguPinguEat.user.Review;
import pinguPinguEat.view.RestaurantGroupController;

import java.util.List;

public class ReviewLogic {
    private final ObservableList<Review> reviewObservableList;

    private final ReviewController reviewController;

    private final RestaurantGroupController restaurantGroupController;

    public ReviewLogic(RestaurantGroupController restaurantGroupController) {
        this.reviewObservableList = FXCollections.observableArrayList();
        this.reviewController = new ReviewController();
        this.restaurantGroupController = restaurantGroupController;
        this.reviewController.getAllReviews(this::setReview);
    }

    /**
     * Should send Review to Server
     * Currently just adding it back to Restaurant View
     *
     * @param review
     */
    public void postReview(Review review) {
        restaurantGroupController.reviews.add(review);

        /*reviewController.addReview(review, new Consumer<List<Review>>() {
            @Override
            public void accept(List<Review> reviews) {
                restaurantGroupController.reviews.clear();
                restaurantGroupController.reviews.addAll(reviews);
            }
        });*/
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
