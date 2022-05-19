package User;

public class Review {
    private final int rating;
    private final String comment;
    private User author;

    public Review(int rating, String comment, User author) {
        this.rating = rating;
        this.comment = comment;
        this.author = author;
    }

    public int getRating() {
        return rating;
    }

    public String getComment() {
        return comment;
    }

    public User getAuthor() {
        return author;
    }
}
