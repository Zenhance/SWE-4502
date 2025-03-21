import java.util.ArrayList;
import java.util.Date;
import java.util.List;

class Issue {
    private final int id;
    private String title;
    private String description;
    private String priority;
    private String status;
    private final Date creationDate;
    private Date lastModifiedDate;
    private final List<String> comments = new ArrayList<>();

    public Issue(int id, String title, String description, String priority) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.priority = priority;
        this.status = "Open"; // Default status 
        this.creationDate = new Date();
        this.lastModifiedDate = creationDate;
    }

    public void update(String title, String description, String priority) {
        this.title = title;
        this.description = description;
        this.priority = priority;
        this.lastModifiedDate = new Date();
    }

    public void changeStatus(String status) {
        this.status = status;
        this.lastModifiedDate = new Date();
    }

    public void addComment(String comment) {
        comments.add(comment);
        this.lastModifiedDate = new Date();
    }

    public int getId() { return id; }
    public String getStatus() { return status; }

    @Override
    public String toString() {
        return "Issue{id=" + id + ", title='" + title + "', status='" + status + "'}";
    }
} 
