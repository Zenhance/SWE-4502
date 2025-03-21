package models;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Issue {
    private String id;
    private String title;
    private String description;
    private Priority priority;
    private Status status;
    private LocalDateTime creationDate;
    private LocalDateTime lastModifiedDate;
    private String assignedTo;
    private Set<String> tags;
    private List<Comment> comments;

    public Issue(String id, String title, String description, Priority priority) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.priority = priority;
        this.status = Status.OPEN;  // Default status
        this.creationDate = LocalDateTime.now();
        this.lastModifiedDate = LocalDateTime.now();
        this.tags = new HashSet<>();
        this.comments = new ArrayList<>();
    }

    // Getters
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

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public LocalDateTime getLastModifiedDate() {
        return lastModifiedDate;
    }

    public String getAssignedTo() {
        return assignedTo;
    }

    public Set<String> getTags() {
        return new HashSet<>(tags);  // Return a copy to maintain encapsulation
    }

    public List<Comment> getComments() {
        return new ArrayList<>(comments);  // Return a copy to maintain encapsulation
    }

    // Setters
    public void setTitle(String title) {
        this.title = title;
        updateLastModifiedDate();
    }

    public void setDescription(String description) {
        this.description = description;
        updateLastModifiedDate();
    }

    public void setPriority(Priority priority) {
        this.priority = priority;
        updateLastModifiedDate();
    }

    public void setStatus(Status status) {
        this.status = status;
        updateLastModifiedDate();
    }

    public void setAssignedTo(String assignedTo) {
        this.assignedTo = assignedTo;
        updateLastModifiedDate();
    }

    // Tag operations
    public void addTag(String tag) {
        tags.add(tag);
        updateLastModifiedDate();
    }

    public void removeTag(String tag) {
        tags.remove(tag);
        updateLastModifiedDate();
    }

    // Comment operations
    public void addComment(Comment comment) {
        comments.add(comment);
        updateLastModifiedDate();
    }

    public void removeComment(String commentId) {
        comments.removeIf(comment -> comment.getId().equals(commentId));
        updateLastModifiedDate();
    }

    private void updateLastModifiedDate() {
        this.lastModifiedDate = LocalDateTime.now();
    }
} 