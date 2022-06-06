package pinguPinguEat.user;

import java.time.Instant;
import java.util.UUID;

public class Review {
    private int rating;
    private String comment;
    private User author;
    private UUID reviewID;

    public Review() {

    }

    public UUID getReviewID() {
        return reviewID;
    }

    public int getRating() {
        return rating;
    }

    public String getComment() {
        return comment;
    }

    public String getAuthorName() {
        return author.getName();
    }

    public void setReviewID(UUID randomUUID) {
    }

    public void setCreationDate(Instant now) {
    }
}
