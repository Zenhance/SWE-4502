import java.time.LocalDateTime;
import java.util.*;

public class Issue {
    private Integer id;
    private String title;
    private String description;
    private Priority priority;
    private Status status;
    private LocalDateTime creationDate;
    private LocalDateTime lastModifiedDate;
    private String assignedTo;
    private List<String> tags;
    private List<Comment> comments;

    public Issue(int id, String title, String description, Priority priority) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.priority = priority;
        this.status = Status.OPEN;
        this.creationDate = LocalDateTime.now();
        this.lastModifiedDate = LocalDateTime.now();
        this.tags = new ArrayList<>();
        this.comments = new ArrayList<>();
    }

    public Issue cloneIssue() {
        Issue copy = new Issue(this.id, title, description, priority);
        copy.status = this.status;
        copy.creationDate = this.creationDate;
        copy.lastModifiedDate = this.lastModifiedDate;
        copy.assignedTo = this.assignedTo;
        copy.tags = new ArrayList<>(this.tags);
        copy.comments = comments.stream().map(Comment::cloneComment).toList();
        return copy;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPriority(Priority priority) {
        this.priority = priority;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public void setCreationDate(LocalDateTime creationDate) {
        this.creationDate = creationDate;
    }

    public void setLastModifiedDate(LocalDateTime lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }

    public void setAssignedTo(String assignedTo) {
        this.assignedTo = assignedTo;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    public Integer getId() { return id; }

    public Status getStatus() {
        return status;
    }

    public void addComment(Comment comment) {
        comments.add(comment);
    }


    public List<Comment> getComments() {
        return comments;
    }


    public String getTitle() {
        return title;
    }
}
