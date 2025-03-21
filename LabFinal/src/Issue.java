import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public class Issue {
    private UUID id;
    private String title;
    private String description;
    private Priority priority;
    private Status status;
    private LocalDateTime creationDate;
    private LocalDateTime lastModifiedDate;
    private String assignedTo;
    private List<String> tags;
    private List<comment> comments;


    public Issue(UUID id, String title, String description, Priority priority, Status status, LocalDateTime creationDate, LocalDateTime lastModifiedDate, String assignedTo, List<String> tags, List<comment> comments) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.priority = priority;
        this.status = status;
        this.creationDate = creationDate;
        this.lastModifiedDate = lastModifiedDate;
        this.assignedTo = assignedTo;
        this.tags = tags;
        this.comments = comments;
    }

    public Issue(int i, String titl1, String description1, String high, String closed, String s, String s1, String sani, String tag2, comment comment) {
    }


    public UUID getId() {
        return null;
    }

}
