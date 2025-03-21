package models;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Issue {
    private int id;
    private String title;
    private String description;
    private String priority;
    private String status;
    private LocalDateTime creationDate;
    private LocalDateTime lastModifiedDate;
    private String assignedTo;
    private List<String> tags;
    private List<Comment> comments;

    public Issue(int id, String title, String description, String priority) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.priority = priority;
        this.status = "Open";
        this.creationDate = LocalDateTime.now();
        this.lastModifiedDate = this.creationDate;
        this.tags = new ArrayList<>();
        this.comments = new ArrayList<>();
    }

    public void addComment(Comment comment) {
        comments.add(comment);
        this.lastModifiedDate = LocalDateTime.now();
    }

    public void setStatus(String status) {
        this.status = status;
        this.lastModifiedDate = LocalDateTime.now();
    }

    public int getId() { return id; }
    public String getTitle() { return title; }
    public String getStatus() { return status; }
}