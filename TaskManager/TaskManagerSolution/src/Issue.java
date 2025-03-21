import java.time.LocalDateTime;
import java.util.*;

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

    public Issue() {
        this.id = UUID.randomUUID().toString();
        this.status = Status.OPEN;
        this.creationDate = LocalDateTime.now();
        this.lastModifiedDate = LocalDateTime.now();
        this.tags = new HashSet<>();
        this.comments = new ArrayList<>();
    }

    private Issue(Issue source) {
        this.id = source.id;
        this.title = source.title;
        this.description = source.description;
        this.priority = source.priority;
        this.status = source.status;
        this.creationDate = source.creationDate;
        this.lastModifiedDate = source.lastModifiedDate;
        this.assignedTo = source.assignedTo;
        this.tags = new HashSet<>(source.tags);
        this.comments = new ArrayList<>();
        for (Comment comment : source.comments) {
            this.comments.add(comment.clone());
        }
    }

    public Issue clone() {
        return new Issue(this);
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
        this.lastModifiedDate = LocalDateTime.now();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
        this.lastModifiedDate = LocalDateTime.now();
    }

    public Priority getPriority() {
        return priority;
    }

    public void setPriority(Priority priority) {
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

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public LocalDateTime getLastModifiedDate() {
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
        return tags;
    }

    public void addTag(String tag) {
        this.tags.add(tag);
        this.lastModifiedDate = LocalDateTime.now();
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void addComment(Comment comment) {
        this.comments.add(comment);
        this.lastModifiedDate = LocalDateTime.now();
    }
}
