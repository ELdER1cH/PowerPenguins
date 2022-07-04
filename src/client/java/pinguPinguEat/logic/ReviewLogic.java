package pinguPinguEat.logic;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import pinguPinguEat.controller.ReviewController;
import pinguPinguEat.user.Review;
import pinguPinguEat.view.SceneController;

import java.util.List;

public class ReviewLogic {
    private final ObservableList<Review> reviewObservableList;
    private SceneController sceneController;
    private ReviewController reviewController;

    public ReviewLogic() {
        this.reviewController = new ReviewController();
        this.sceneController = new SceneController();
        this.reviewObservableList = FXCollections.observableArrayList();

        reviewController.getAllReviews(this::setReview);
    }

    //    create
    public void postReview() {

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
