import java.util.Date;

public class Comment {
    public int id;
    public String content;
    public String author;
    public Date createdAt;

    public Comment(int id, String content, String author, Date createdAt) {
        this.id = id;
        this.content = content;
        this.author = author;
        this.createdAt = createdAt;
    }

}
