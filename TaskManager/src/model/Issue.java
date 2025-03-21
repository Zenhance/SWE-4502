package model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

public class Issue implements Cloneable {
    private String id;
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
        this.id = UUID.randomUUID().toString();
        this.title = title;
        this.description = description;
        this.priority = priority;
        this.status = Status.Open; // keeping open by default
        this.creationDate = new Date();
        this.lastModifiedDate = new Date();
        this.tags = new ArrayList<>();
        this.comments = new ArrayList<>();
    }

    // all getters and setters will go here
    public String getId() {

        return id;
    }

    public String getTitle() {

        return title;
    }

    public void setTitle(String title) {
        this.title = title;
        this.lastModifiedDate = new Date();
    }

    public String getDescription() {

        return description;
    }

    public void setDescription(String description) {
        this.description = description;
        this.lastModifiedDate = new Date();
    }

    public Priority getPriority() {

        return priority;
    }

    public void setPriority(Priority priority) {
        this.priority = priority;
        this.lastModifiedDate = new Date();
    }

    public Status getStatus() {

        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
        this.lastModifiedDate = new Date();
    }

    public Date getCreationDate() {

        return creationDate;
    }

    public Date getLastModifiedDate() {

        return lastModifiedDate;
    }

    public void setLastModifiedDate(Date lastModifiedDate) {

        this.lastModifiedDate = lastModifiedDate;
    }

     public String getAssignedTo() {

        return assignedTo;
    }

    public void setAssignedTo(String assignedTo) {
        this.assignedTo = assignedTo;
        this.lastModifiedDate = new Date();
    }

    public List<String> getTags() {
        return tags;
    }

    public void addTag(String tag) {
        this.tags.add(tag);
        this.lastModifiedDate = new Date();
    }

    public void removeTag(String tag) {
        this.tags.remove(tag);
        this.lastModifiedDate = new Date();
    }

    public void addComment(Comment comment) {
        this.comments.add(comment);
        this.lastModifiedDate = new Date();
    }

    public List<Comment> getComments() {
        return comments;
    }

    @Override
    public Issue clone() {
        try {
            Issue clonedIssue = (Issue) super.clone();
            // Deep clone mutable fields
            clonedIssue.tags = new ArrayList<>(this.tags);
            clonedIssue.comments = new ArrayList<>();
            for (Comment comment : this.comments) {
                clonedIssue.comments.add(comment.clone());
            }
            return clonedIssue;
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException("Issue cloning failed", e);
        }
    }
}