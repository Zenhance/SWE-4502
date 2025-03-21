package Lab_Final_210042150.Task_Management_System.Models.CommentModel;

import java.time.LocalDateTime;
import java.util.UUID;


public class Comment implements Cloneable{
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

    private Comment() {}

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

    @Override
    public Comment clone() {
        Comment clone = new Comment();
        clone.id = this.id;
        clone.content = this.content;
        clone.author = this.author;
        clone.createdAt = this.createdAt;
        return clone;
    }
}
