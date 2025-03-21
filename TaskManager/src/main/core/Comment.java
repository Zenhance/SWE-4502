package main.core;

import java.time.LocalDate;
import java.util.UUID;

public class Comment {
    
    private String id;
    private String content;
    private String author;
    private LocalDate createdAt;

    public Comment(String _content, String _author) {
        UUID uuid = UUID.randomUUID();
        this.id = uuid.toString();
        this.content = _content;
        this.author = _author;
        this.createdAt = LocalDate.now();
    }

    public String GetId() {
        return id;
    }

    public String GetContent() {
        return content;
    }

    public String GetAuthor() {
        return author;
    }

    public LocalDate GetCreatedAt() {
        return createdAt;
    }

}
