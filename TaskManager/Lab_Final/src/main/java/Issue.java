import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Issue {
    private String id;
    public String title;
    public String description;
    public Status status;
    public Priority priority;
    public Date creationDate;
    public Date lastModifiedDate;
    public String assignTo;
    public List<String> tags = new ArrayList<>();
    public List<Comment> comments = new ArrayList<>();

    public Issue (String title, String description, Status status, Priority priority, String assignTo) {
        this.title = title;
        this.description = description;
        this.status = status;
        this.priority = priority;
        this.assignTo = assignTo;
        this.creationDate = new Date();
        this.lastModifiedDate = new Date();
    }

    public enum Status {
        Open, InProgress,UnderReview ,Resolved, Closed
    }

    public enum Priority {
        Low, Medium, High,Critical
    }



}
