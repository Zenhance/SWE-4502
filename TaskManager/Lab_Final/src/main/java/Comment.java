import java.util.Date;

public class Comment {
    private int id = 0;
    public Issue issue;
    public String content;
    public String author;
    public Date createdAt;

    public Comment(String content) {
        this.id = id++;
        this.content = content;
        this.createdAt = new Date();
    }
    public int getId() {
        return id;
    }
    public String getContent() {
        return content;
    }
    public Date getCreatedAt() {
        return createdAt;
    }

}