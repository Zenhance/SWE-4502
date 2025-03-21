import java.time.LocalDateTime;
import java.util.List;

public class Issue implements Prototype{
    private String id;
    private String title;
    private Enum<PRIORITY> priority;
    private Enum<STATUS> status;
    private LocalDateTime creationDate;
    private LocalDateTime lastModifiedDate;
    private User assignedTo;
    private List<String> tags;
    private List<String> comments;

    public Issue(String id, String title, Enum<PRIORITY> priority, Enum<STATUS> status, User assignedTo) {
        this.id = id;
        this.title = title;
        this.priority = priority;
        this.status = status;
        this.assignedTo = assignedTo;
    }

    @Override
    public Issue clone() {
        return new Issue(this.id,this.title,this.priority,this.status,this.assignedTo);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Enum<PRIORITY> getPriority() {
        return priority;
    }

    public void setPriority(Enum<PRIORITY> priority) {
        this.priority = priority;
    }

    public Enum<STATUS> getStatus() {
        return status;
    }

    public void setStatus(Enum<STATUS> status) {
        this.status = status;
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDateTime creationDate) {
        this.creationDate = creationDate;
    }

    public LocalDateTime getLastModifiedDate() {
        return lastModifiedDate;
    }

    public void setLastModifiedDate(LocalDateTime lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }

    public User getAssignedTo() {
        return assignedTo;
    }

    public void setAssignedTo(User assignedTo) {
        this.assignedTo = assignedTo;
    }

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    public List<String> getComments() {
        return comments;
    }

    public void setComments(List<String> comments) {
        this.comments = comments;
    }
}


