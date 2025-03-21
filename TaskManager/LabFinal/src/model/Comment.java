package model;
import java.time.LocalDateTime;
import java.util.UUID;

public class Comment{
    private String id;
    private String content;
    private String author;
    private LocalDateTime createdAt;

    public Comment(String content, String author) {
        this.id = UUID.randomUUID().toString();
        this.content = content;
        this.author = author;
        this.createdAt = LocalDateTime.now();
    }

    public String getId() {
        return id;
    }
    public String getContent() {
        return content;
    }
    public String getAuthor() {
        return author;
    }
    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
}
