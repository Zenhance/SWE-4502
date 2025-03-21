package models;

import java.security.Timestamp;
import java.time.LocalDateTime;

public class Comment {
    private String id;
    private String content;
    private String author;
    private LocalDateTime createdAt;

    public String getId(){
        return id;
    }
    public String getContent(){
        return content;
    }
    public String getAuthor(){
        return author;
    }
    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
    public void setId(String id){
        this.id = id;
    }
    public  void setContent(String content){
        this.content = content;
    }
    public  void setAuthor(String author){
        this.author = author;
    }
    public void setCreatedAt(LocalDateTime createdAt){
        this.createdAt = createdAt;
    }
}
