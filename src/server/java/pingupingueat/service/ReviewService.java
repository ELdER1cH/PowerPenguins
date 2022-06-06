package pinguPinguEat.service;

import org.springframework.stereotype.Service;
import pinguPinguEat.user.Review;

import java.time.Instant;
import java.util.List;
import java.util.UUID;

@Service
public class ReviewService {
    private final List<Review> reviews;

    public ReviewService(List<Review> reviews) {
        this.reviews = reviews;
    }

    public Review postReview(Review review) {
        var optionalNote = reviews.stream().filter(existingReview -> existingReview.getReviewID().equals(review.getReviewID())).findFirst();

        if (optionalNote.isEmpty()) {
            review.setReviewID(UUID.randomUUID());
            review.setCreationDate(Instant.now());
            reviews.add(review);
            return review;
        } else {
//already exists a review
            return null;
        }
    }

    public boolean deleteReview(UUID reviewID) {
        return this.reviews.removeIf(review -> review.getReviewID().equals(reviewID));
    }

    public List<Review> getAllReviews() {
// Maybe add some sorting options in the future
        return this.reviews;
    }
}
