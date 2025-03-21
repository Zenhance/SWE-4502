import java.time.LocalDateTime;

public class Comment {
    private String Id;
    String Content;
    Author author;
    LocalDateTime CreatedAt;

    public Comment(String Content, Author author){
        this.Content= Content;
        this.author= author;
        this.CreatedAt= LocalDateTime.now();
    }


}
