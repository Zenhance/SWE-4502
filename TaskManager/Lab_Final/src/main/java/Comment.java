import java.util.Date;

public class Comment {
    private int id;
    public String content;
    public String author;
    public Date createdAt;

    public Comment(int id, String content, String author) {
        this.id = id;
        this.content = content;
        this.author = author;
        this.createdAt = new Date();
    }

}