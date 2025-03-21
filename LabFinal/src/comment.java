import java.time.LocalDateTime;
import java.util.UUID;

public class comment {

    private UUID id;
    private String content;
    private String author;
    private LocalDateTime createdAt;

    public comment(UUID id, String content, String author, LocalDateTime createdAt) {
        this.id = id;
        this.content = content;
        this.author = author;
        this.createdAt = createdAt;
    }
}
