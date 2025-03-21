import java.time.LocalDateTime;

public class Comment {
    private String Id;
    String Content;
    User author;
    LocalDateTime CreatedAt;

    public Comment(String Content, User author){
        this.Content= Content;
        this.author= author;
        this.CreatedAt= LocalDateTime.now();
    }


}
