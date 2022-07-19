package pinguPinguEat.restaurants;


import pinguPinguEat.reservationModel.ReservationSystem;
import pinguPinguEat.user.Review;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Restaurant {
    private final String name;
    private final String address;
    private final CuisineType cuisineType;
    private final PriceCategory priceCategory;
    private final String description;
    private final ReservationSystem reservationSystem;
    private final List<Review> reviews;
    private double averageRating;
    private int sumOfRatings;
    private final List<String> images;
    private final UUID restaurantID;
    private final String openingTimes;
    private final String link;
    private final int mapID;


    public Restaurant(String name, String address, CuisineType cuisineType, PriceCategory priceCategory,
                      String description, ReservationSystem seatingPlan,
                      String openingTimes, String link , int mapID) {
        this.name = name;
        this.address = address;
        this.cuisineType = cuisineType;
        this.priceCategory = priceCategory;
        this.description = description;
        this.reservationSystem = seatingPlan;
        this.openingTimes = openingTimes;
        this.link = link;
        this.reviews = new ArrayList<>();
        averageRating = 0;
        sumOfRatings = 0;
        images = new ArrayList<>();
        restaurantID = UUID.randomUUID();
        this.mapID = mapID;
    }

    public String getDescription() {
        return description;
    }

    public String getName() {
        return name;
    }


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
        this.reviews.add(review);
        this.sumOfRatings += review.getRating();
        this.averageRating = sumOfRatings / reviews.size();
    }

    public void addImage(String url) {
        this.images.add(url);
    }

    @Override
    public String toString() {
        return "Name: " + name + " Rating: " + averageRating;
    }

    public String getOpeningTimes() {
        return openingTimes;
    }

    public String getLink() {
        return link;
    }

    public List<String> getImages() {
        return images;
    }

    public int getMapID() {
        return mapID;
    }
}
