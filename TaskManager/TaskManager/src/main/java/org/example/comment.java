package org.example;

import java.util.Date;
import java.util.UUID;

class Comment {
    private final UUID id;
    private final String content;
    private final String author;
    private final Date createdAt;

    public Comment(String content, String author) {
        this.id = UUID.randomUUID();
        this.content = content;
        this.author = author;
        this.createdAt = new Date();
    }

    public String getContent() { return content; }
    public String getAuthor() { return author; }
    public Date getCreatedAt() { return createdAt; }
}