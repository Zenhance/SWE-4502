import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Issue {
    private int id = 54321;
    public String title;
    public String description;
    public Status status;
    public Priority priority;
    public Date creationDate;
    public Date lastModifiedDate;
    public String assignTo;
    public List<String> tags = new ArrayList<>();
    public List<Comment> comments = new ArrayList<>();

    public Issue (String title, String description,String assignTo) {
        this.id = id++;
        this.title = title;
        this.description = description;
        setStatus(Status.Open);
        setPriority(Priority.Low);
        this.assignTo = assignTo;
        this.creationDate = new Date();
        this.lastModifiedDate = new Date();
    }
    public int getId() {
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

    public Date getCreationDate() {
        return creationDate;
    }

    public Date getLastModifiedDate() {
        return lastModifiedDate;
    }

    public void setTitle(String title) {
        this.title = title;
        updateLastModifiedDate();
    }

    public void setDescription(String description) {
        this.description = description;
        updateLastModifiedDate();
    }

    public void setPriority(Priority priority) {
        this.priority = priority;
        updateLastModifiedDate();
    }

    public void setStatus(Status status) {
        this.status = status;
        updateLastModifiedDate();
    }

    private void updateLastModifiedDate() {
        this.lastModifiedDate = new Date();
    }

    public enum Status {
        Open, InProgress,UnderReview ,Resolved, Closed
    }

    public enum Priority {
        Low, Medium, High,Critical
    }



}
