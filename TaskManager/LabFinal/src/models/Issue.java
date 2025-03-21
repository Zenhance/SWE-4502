package models;

import enums.Priority;
import enums.Status;

import java.util.Date;
import java.util.List;

public class Issue {
    private String id;
    String title;
    String description;
    Priority priority;
    Status status;
    Date CreationDate;
    Date LastModifiedDate;
    String assignedTo;
    List<String> tags;
    List<Comment> comments;

    public Issue(String title, String description, Priority priority){
        this.title = title;
        this.description = description;
        this.priority = priority;
    }
    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public Priority getPriority() {
        return priority;
    }

    public Status getStatus() {
        return status;
    }

    public Date getCreationDate() {
        return CreationDate;
    }

    public Date getLastModifiedDate() {
        return LastModifiedDate;
    }

    public String getAssignedTo() {
        return assignedTo;
    }

    public List<String> getTags() {
        return tags;
    }

    public List<Comment> getComments() {
        return comments;
    }
}
