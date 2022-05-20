package restaurants;

import user.Review;

import java.util.ArrayList;
import java.util.List;

public class Restaurant {
    private final String name;
    private final CuisinType cuisinType;
    private final PriceCategory priceCategory;
    private final ReservationSystem reservationSystem;
    private List<Review> reviews;
    private double averageRating;
    private int sumOfRatings;
    private List<String> images;

    public Restaurant(String name, CuisinType cuisinType, PriceCategory priceCategory, ReservationSystem seatingPlan) {
        this.name = name;
        this.cuisinType = cuisinType;
        this.priceCategory = priceCategory;
        this.reservationSystem = seatingPlan;
        reviews = new ArrayList<>();
        averageRating = 0;
        sumOfRatings = 0;
        images = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public CuisinType getCuisinType() {
        return cuisinType;
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

    public void addReview(Review review){
        //TODO implement addReview with updating sumOfRating
    }
}
