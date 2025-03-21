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
}
