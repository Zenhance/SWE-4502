import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;

public class Issue implements Cloneable {
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

    public Issue(String title, String description, Priority priority) {
        this.id = UUID.randomUUID().toString();
        this.title = title;
        this.description = description;
        this.priority = priority;
        this.status = Status.Open;
        this.creationDate = LocalDateTime.now();
        this.lastModifiedDate = LocalDateTime.now();
        this.tags = new HashSet<>();
        this.comments = new ArrayList<>();
    }
    private Issue(Issue other) {
        this.id = other.id;
        this.title = other.title;
        this.description = other.description;
        this.priority = other.priority;
        this.status = other.status;
        this.creationDate = other.creationDate;
        this.lastModifiedDate = other.lastModifiedDate;
        this.assignedTo = other.assignedTo;
        this.tags = new HashSet<>(other.tags);
        this.comments = new ArrayList<>();
        for (Comment comment : other.comments) {
            this.comments.add(comment.clone());
        }
    }
    @Override
    public Issue clone() {
        return new Issue(this);
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
        return new HashSet<>(tags);
    }
    public List<Comment> getComments() {
        return new ArrayList<>(comments);
    }
    public void setTitle(String title) {
        this.title = title;
        this.lastModifiedDate = LocalDateTime.now();
    }
    public void setDescription(String description) {
        this.description = description;
        this.lastModifiedDate = LocalDateTime.now();
    }
    public void setPriority(Priority priority) {
        this.priority = priority;
        this.lastModifiedDate = LocalDateTime.now();
    }
    public void setStatus(Status status) {
        this.status = status;
        this.lastModifiedDate = LocalDateTime.now();
    }
    public void setAssignedTo(String assignedTo) {
        this.assignedTo = assignedTo;
        this.lastModifiedDate = LocalDateTime.now();
    }

    public void addTag(String tag) {
        this.tags.add(tag);
        this.lastModifiedDate = LocalDateTime.now();
    }
    public void removeTag(String tag) {
        this.tags.remove(tag);
        this.lastModifiedDate = LocalDateTime.now();
    }
    public void addComment(Comment comment) {
        this.comments.add(comment);
        this.lastModifiedDate = LocalDateTime.now();
    }
    public void removeComment(String commentId) {
        this.comments.removeIf(comment -> comment.getId().equals(commentId));
        this.lastModifiedDate = LocalDateTime.now();
    }
    @Override
    public String toString() {
        return "Issue{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", priority=" + priority +
                ", status=" + status +
                ", assignedTo='" + assignedTo + '\'' +
                '}';
    }
}
