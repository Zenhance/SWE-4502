package Lab_Final_210042150.Task_Management_System.Models.DomainModel;

import Lab_Final_210042150.Task_Management_System.Models.CommentModel.Comment;
import java.time.LocalDateTime;
import java.util.Set;
import java.util.List;
import java.util.UUID;
import java.util.HashSet;
import java.util.ArrayList;

public class Issue implements Cloneable{
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

    public Issue(String title,String description,Priority priority)
    {
        this.id = UUID.randomUUID().toString();
        this.title = title;
        this.description = description;
        this.priority = priority;
        this.status = Status.Open;
        this.creationDate = LocalDateTime.now();
        this.lastModifiedDate = this.creationDate;
        this.tags = new HashSet<>();
        this.comments = new ArrayList<>();
    }

    private Issue() {
        this.tags = new HashSet<>();
        this.comments = new ArrayList<>();
    }

    public String getId()
    {
        return id;
    }

    public String getTitle()
    {
        return title;
    }

    public void setTitle(String title)
    {
        this.title = title;
        this.lastModifiedDate = LocalDateTime.now();
    }

    public String getDescription()
    {
        return description;
    }

    public void setDescription(String description)
    {
        this.description = description;
        this.lastModifiedDate = LocalDateTime.now();
    }

    public Priority getPriority()
    {
        return priority;
    }
    public void setPriority(Priority priority)
    {
        this.priority = priority;
        this.lastModifiedDate = LocalDateTime.now();
    }
    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
        this.lastModifiedDate = LocalDateTime.now();
    }

    public LocalDateTime getCreationDate()
    {
        return creationDate;
    }

    public LocalDateTime getLastModifiedDate()
    {
        return lastModifiedDate;
    }

    public String getAssignedTo() {
        return assignedTo;
    }

    public void setAssignedTo(String assignedTo) {
        this.assignedTo = assignedTo;
        this.lastModifiedDate = LocalDateTime.now();
    }

    public Set<String> getTags() {
        return new HashSet<>(tags);
    }

    public void addTag(String tag) {
        this.tags.add(tag);
        this.lastModifiedDate = LocalDateTime.now();
    }

    public void removeTag(String tag) {
        this.tags.remove(tag);
        this.lastModifiedDate = LocalDateTime.now();
    }

    public List<Comment> getComments() {
        return new ArrayList<>(comments);
    }

    public void addComment(Comment comment) {
        this.comments.add(comment);
        this.lastModifiedDate = LocalDateTime.now();
    }

    @Override
    public Issue clone()
    {
        Issue clone = new Issue();
        clone.id = this.id;
        clone.title = this.title;
        clone.description = this.description;
        clone.priority = this.priority;
        clone.status = this.status;
        clone.creationDate = this.creationDate;
        clone.lastModifiedDate = this.lastModifiedDate;
        clone.assignedTo = this.assignedTo;
        clone.tags = new HashSet<>(this.tags);
        clone.comments = new ArrayList<>();
        for (Comment comment : this.comments) {
            clone.comments.add(comment.clone());
        }

        return clone;
    }

}
