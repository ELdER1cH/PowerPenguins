package pinguPinguEat.controller;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;
import pinguPinguEat.user.Review;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class ReviewController {

    private final WebClient webClient;
    private final List<Review> reviews;

    public ReviewController() {
        this.webClient = WebClient.builder()
                .baseUrl("http://localhost:8080/")
                .defaultHeader(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON_VALUE)
                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .build();
        this.reviews = new ArrayList<>();
    }

    public void addReview(Review review, Consumer<List<Review>> reviewsConsumer) {
        webClient.post()
                .uri("reviews")
                .bodyValue(review)
                .retrieve()
                .bodyToMono(Review.class)
                .onErrorStop()
                .subscribe(newReview -> {
                    reviews.add(review);
                    reviewsConsumer.accept(reviews);
                });
    }

    public void deleteReview(Review review, Consumer<List<Review>> reviewsConsumer) {
        webClient.delete()
                .uri("reviews/" + review.getReviewID())
                .retrieve()
                .toBodilessEntity()
                .onErrorStop()
                .subscribe(v -> {
                    reviews.remove(review);
                    reviewsConsumer.accept(reviews);
                });
    }

    public void getAllReviews(Consumer<List<Review>> reviewsConsumer) {
        webClient.get()
                .uri(uriBuilder -> uriBuilder
                        .path("reviews")
                        .build())
                .retrieve()
                .bodyToMono(new ParameterizedTypeReference<List<Review>>() {
                })
                .onErrorStop()
                .subscribe(newReviews -> {
                    reviews.clear();
                    reviews.addAll(newReviews);
                    reviewsConsumer.accept(reviews);
                });
    }
}
