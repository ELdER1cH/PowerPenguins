package PinguPinguEat.user;

public class Review {
    private final int rating;
    private final String comment;
    private final User author;

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

    public String getAuthorName() {
        return author.getName();
    }
}
