package pinguPinguEat.restaurants;


import pinguPinguEat.reservationModel.ReservationSystem;
import pinguPinguEat.user.Review;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity(name = "Restaurant")
@Table(name = "restaurants")
public class Restaurant {

    //TODO had to make the attributes non final to check something
    @Column(name = "name", updatable = false, nullable = false, columnDefinition = "TEXT")
    private String name;

    @Column(name = "cuisine_type", updatable = false)
    private CuisineType cuisineType;

    @Column(name = "price_category", updatable = false)
    private PriceCategory priceCategory;

    @Transient //TODO what should I do with this
    private ReservationSystem reservationSystem;

    @Transient //TODO what should I do with this
    private List<Review> reviews;
    private double averageRating;
    private int sumOfRatings;
    @ElementCollection
    private List<String> images;

    @Id
    @Column(name = "id", updatable = false, nullable = false, unique = true)
    private UUID reservationID;

    public Restaurant(String name, CuisineType cuisineType, PriceCategory priceCategory, ReservationSystem seatingPlan) {
        this.name = name;
        this.cuisineType = cuisineType;
        this.priceCategory = priceCategory;
        this.reservationSystem = seatingPlan;
        reviews = new ArrayList<>();
        averageRating = 0;
        sumOfRatings = 0;
        images = new ArrayList<>();
        reservationID = UUID.fromString(name);
    }

    public Restaurant() {

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

    public UUID getReservationID() {
        return reservationID;
    }

    public ReservationSystem getReservationSystem() {
        return reservationSystem;
    }

    public void addReview(Review review) {
        //TODO implement addReview with updating sumOfRating and average Rating
    }
}
