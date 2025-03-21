import java.time.LocalDateTime;
import java.util.UUID;

public class Comment {
    private UUID id;
    private String content;
    private String author;
    private LocalDateTime createdAt;

    public Comment(String content, String author) {
        this.id = UUID.randomUUID();
        this.content = content;
        this.author = author;
        this.createdAt = LocalDateTime.now();
    }

    public Comment cloneComment() {
        Comment copy = new Comment(this.content, this.author);
        copy.id = this.id;
        copy.createdAt = this.createdAt;
        return copy;
    }

    public String getAuthor() {
        return author;
    }
}
