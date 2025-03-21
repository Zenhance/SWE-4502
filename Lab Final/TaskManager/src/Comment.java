import java.util.Date;
public class Comment {
    public int ID;
    public String content;
    public String author;
    public Date CreatedAt;

    public Comment(int ID, String content, String author, Date CreatedAt) {
        this.ID = ID;
        this.content = content;
        this.author = author;
        this.CreatedAt = CreatedAt;
    }
}
