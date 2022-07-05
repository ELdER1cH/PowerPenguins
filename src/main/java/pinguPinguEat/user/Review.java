package pinguPinguEat.user;

import java.time.Instant;
import java.util.UUID;

public class Review {
    private final int rating;
    private final String title;
    private final String comment;
    private final User author;
    private UUID reviewID;

    public Review(int rating, String title, String comment, User author) {
        this.rating = rating;
        this.title = title;
        this.comment = comment;
        this.author = author;
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

    @Override
    public String toString() {
        return "Title: " + title + "\nRating: " + rating + "\nComment: " + comment + "\nAuthor: " + author.toString();
    }
}
