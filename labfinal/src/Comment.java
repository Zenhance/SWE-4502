import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public class Comment {
    public String id;
    public String content;
    public String author;
    public LocalDateTime createdAt;

    public Comment() {
        this.id = UUID.randomUUID().toString();
        this.createdAt = LocalDateTime.now();
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
