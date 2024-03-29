package de.tum.in.ase.eist.service;

import org.springframework.stereotype.Service;
import pinguPinguEat.userElement.Review;

import java.util.HashMap;
import java.util.UUID;

@Service
public class ReviewService {
    private final HashMap<UUID, Review> reviews;

    public ReviewService() {
        this.reviews = new HashMap<>();
    }

    public Review postReview(Review review) {
        review.setReviewID(UUID.randomUUID());
        this.reviews.put(review.getReviewID(), review);
        return this.reviews.get(review.getReviewID());
    }

    public boolean deleteReview(UUID reviewID) {
        return this.reviews.remove(reviewID) != null;
    }

    public HashMap<UUID, Review> getAllReviews() {
// Maybe add some sorting options in the future
        return this.reviews;
    }
}
