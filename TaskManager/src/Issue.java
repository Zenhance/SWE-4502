import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

class Issue {
    public enum Priority { LOW, MEDIUM, HIGH, CRITICAL }
    public enum Status { OPEN, IN_PROGRESS, UNDER_REVIEW, RESOLVED, CLOSED }

    private final String id;
    private String title, description, assignedTo;
    private Priority priority;
    private Status status;
    //private final Date creationDate;
    private Date lastModifiedDate;
    private List<Comment> comments;

    public Issue(String id, String title, String description, Priority priority) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.priority = priority;
        this.status = Status.OPEN;
       // this.creationDate = new Date();
      //  this.lastModifiedDate = new Date();
        this.comments = new ArrayList<>();
    }

    public void update(String title, String description, Priority priority, String assignedTo) {
        this.title = title;
        this.description = description;
        this.priority = priority;
        this.assignedTo = assignedTo;
       // this.lastModifiedDate = new Date();
    }

    public void changeStatus(Status newStatus) {
        this.status = newStatus;
       //this.lastModifiedDate = new Date();
    }

    public void addComment(Comment comment) {
        comments.add(comment);
       // this.lastModifiedDate = new Date();
    }

    public String getId() { return id; }
    public String getTitle() { return title; }
    public Status getStatus() { return status; }
}

