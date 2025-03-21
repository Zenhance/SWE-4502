package org.example;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

class Issue implements Cloneable {
    private final UUID id;
    private String title;
    private String description;
    private Priority priority;
    private Status status;
    private Date creationDate;
    private Date lastModifiedDate;
    private String assignedTo;
    private List<String> tags;
    private List<Comment> comments;

    public Issue(String title, String description, Priority priority) {
        this.id = UUID.randomUUID();
        this.title = title;
        this.description = description;
        this.priority = priority;
        this.status = Status.OPEN;
        this.creationDate = new Date();
        this.lastModifiedDate = new Date();
        this.tags = new ArrayList<>();
        this.comments = new ArrayList<>();
    }

    public void update(String title, String description, Priority priority) {
        this.title = title;
        this.description = description;
        this.priority = priority;
        this.lastModifiedDate = new Date();
    }

    public void changeStatus(Status status) {
        this.status = status;
        this.lastModifiedDate = new Date();
    }

    public void addComment(String content, String author) {
        this.comments.add(new Comment(content, author));
        this.lastModifiedDate = new Date();
    }

    public UUID getId() { return id; }
    public Status getStatus() { return status; }
    public Issue clone() throws CloneNotSupportedException {
        return (Issue) super.clone();
    }
}