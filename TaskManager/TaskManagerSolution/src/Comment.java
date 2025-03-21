import java.time.LocalDateTime;
import java.util.UUID;

public class Comment {
    private String id;
    private String content;
    private String author;
    private LocalDateTime createdAt;

    public Comment() {
        this.id = UUID.randomUUID().toString();
        this.createdAt = LocalDateTime.now();
    }

    private Comment(Comment source) {
        this.id = source.id;
        this.content = source.content;
        this.author = source.author;
        this.createdAt = source.createdAt;
    }


    public Comment clone() {
        return new Comment(this);
    }

    public String getId() {
        return id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
}
