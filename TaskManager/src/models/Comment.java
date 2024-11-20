package models;

import java.time.LocalDateTime;

public class Comment {
    private int id;
    private String content;
    private String author;
    private LocalDateTime createdAt;

    public Comment(int id, String content, String author) {
        this.id = id;
        this.content = content;
        this.author = author;
        this.createdAt = LocalDateTime.now();
}
}