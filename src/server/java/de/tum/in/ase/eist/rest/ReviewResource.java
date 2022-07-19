package de.tum.in.ase.eist.rest;

import de.tum.in.ase.eist.service.ReviewService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pinguPinguEat.user.Review;

import java.util.HashMap;
import java.util.UUID;

@RestController
@RequestMapping(consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
public class ReviewResource {
    private final ReviewService reviewService;

    public ReviewResource(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    @PostMapping("reviews")
    public ResponseEntity<Review> createReview(@RequestBody Review review) {
        if (review.getReviewID() != null) {
            return ResponseEntity.badRequest().build();
        } else {
            return ResponseEntity.ok(reviewService.postReview(review));
        }
    }

    @DeleteMapping("reviews/{reviewID}")
    public ResponseEntity<HttpStatus> deleteReview(@PathVariable("reviewID") UUID reviewID) {
        if (!reviewService.deleteReview(reviewID)) {
            return ResponseEntity.badRequest().build();
        } else {
            return ResponseEntity.noContent().build();
        }
    }

    @GetMapping("reviews")
    public ResponseEntity<HashMap<UUID, Review>> getAllReviews() {
        return ResponseEntity.ok(reviewService.getAllReviews());
    }

}
