package pinguPinguEat.service;

import org.springframework.stereotype.Service;
import pinguPinguEat.user.Review;

import java.util.List;

@Service
public class ReviewService {
    private final List<Review> reviews;

    public ReviewService(List<Review> reviews) {
        this.reviews = reviews;
    }

    public Review postReview(Review review) {
        boolean isSuccessful = reviews.add(review);
//do not allow an empty review
        if (review.getComment() == null) {
            isSuccessful = false;
        }

        if (isSuccessful) {
            return review;
        } else {
            return null;
        }
    }

    public boolean deleteReview(Review review) {
        return reviews.remove(review);
    }

    public List<Review> getAllReviews() {
// Maybe add some sorting options in the future
        return this.reviews;
    }
}
