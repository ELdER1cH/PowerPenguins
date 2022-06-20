package pinguPinguEat.restaurants;


import pinguPinguEat.reservationModel.ReservationSystem;
import pinguPinguEat.user.Review;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Restaurant {
    private final String name;
    private final CuisineType cuisineType;
    private final PriceCategory priceCategory;
    private final ReservationSystem reservationSystem;
    private final List<Review> reviews;
    private final double averageRating;
    private final int sumOfRatings;
    private final List<String> images;
    private final UUID restaurantID;

    public Restaurant(String name, CuisineType cuisineType, PriceCategory priceCategory, ReservationSystem seatingPlan) {
        this.name = name;
        this.cuisineType = cuisineType;
        this.priceCategory = priceCategory;
        this.reservationSystem = seatingPlan;
        reviews = new ArrayList<>();
        averageRating = 0;
        sumOfRatings = 0;
        images = new ArrayList<>();
        restaurantID = UUID.randomUUID();
    }

    public String getName() { return name; }


    public CuisineType getCuisineType() {
        return cuisineType;
    }

    public PriceCategory getPriceCategory() {
        return priceCategory;
    }

    public List<Review> getReviews() {
        return reviews;
    }

    public double getAverageRating() {
        return averageRating;
    }

    public UUID getRestaurantID() {
        return restaurantID;
    }

    public ReservationSystem getReservationSystem() {
        return reservationSystem;
    }

    public void addReview(Review review) {
        //TODO implement addReview with updating sumOfRating and average Rating
    }
}
