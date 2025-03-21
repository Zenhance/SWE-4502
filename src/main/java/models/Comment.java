package models;

import java.time.LocalDateTime;

public class Comment {
    private String id;
    private String content;
    private String author;
    private LocalDateTime createdAt;

    public Comment(String id, String content, String author) {
        this.id = id;
        this.content = content;
        this.author = author;
        this.createdAt = LocalDateTime.now();
    }

    // Getters
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

    // Setters
    public void setContent(String content) {
        this.content = content;
    }
} 