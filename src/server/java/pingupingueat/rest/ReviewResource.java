package pingupingueat.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pingupingueat.service.ReviewService;
import pingupingueat.user.Review;

import java.util.List;

@RestController
@RequestMapping(consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
public class ReviewResource {
    private final ReviewService reviewService;

    public ReviewResource(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    @PostMapping("reviews")
    public ResponseEntity<Review> createReview(@RequestBody Review review) {
        if (reviewService.postReview(review) == null) {
            return ResponseEntity.badRequest().build();
        } else {
            return ResponseEntity.ok(reviewService.postReview(review));
        }
    }

    @DeleteMapping("reviews")
    public ResponseEntity<HttpStatus> cancelReview(@PathVariable Review review) {
        if (!reviewService.deleteReview(review)) {
            return ResponseEntity.badRequest().build();
        } else {
            return ResponseEntity.noContent().build();
        }
    }

    @GetMapping("reviews")
    public ResponseEntity<List<Review>> getAllReviews() {
        return ResponseEntity.ok(reviewService.getAllReviews());
    }

}
