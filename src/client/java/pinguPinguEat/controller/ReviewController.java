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

    private WebClient webClient;
    private List<Review> reviews;

    public ReviewController() {
        this.webClient = WebClient.builder()
                .baseUrl("http://localhost:8080/")
                .defaultHeader(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON_VALUE)
                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .build();
        this.reviews = new ArrayList<>();
    }

// All the methods below use an argument: Consumer<List<Review>> reviewsConsumer
// I just imitated the Class PersonController of H05E01 and have no idea why we need a consumer.
// Or maybe it is not necessary to use it.
// I already posted a question about Consumer on Zulip and wait for the reply to make a better decision.

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
// I'm not sure if review.getComment() works, cause review has no ID attribute.
// And it's possible that there are some reviews with the same content, author or rating.
// But ID is never gonna have the same value.So maybe also add an attribute UUID ID for Class Review?
                .uri("reviews/" + review.getComment())
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
