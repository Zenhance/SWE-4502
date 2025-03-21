package model;

import java.util.Date;
import java.util.UUID;

public class Comment implements Cloneable {
     private String id;

    private String content;
    private String author;

    private Date createdAt;

    public Comment(String content, String author) {
        this.id = UUID.randomUUID().toString();
        this.content = content;
        this.author = author;
        this.createdAt = new Date();
    }


    // getters here
    public String getId() {

        return id;
    }

    public String getContent() {

        return content;
    }
     public String getAuthor() {

        return author;
    }


    public Date getCreatedAt() {

        return createdAt;
    }


    @Override
    public Comment clone() {
        try {
            return (Comment) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException("Comment cloning failed", e);
        }
    }
}