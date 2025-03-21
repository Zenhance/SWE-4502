import java.util.*;

enum Priority { LOW, MEDIUM, HIGH, CRITICAL }
enum Status { OPEN, IN_PROGRESS, UNDER_REVIEW, RESOLVED, CLOSED }

class Issue {
    private static int counter = 1;
    private int id;
    private String title;
    private String description;
    private Priority priority;
    private Status status;
    private Date creationDate;
    private Date lastModifiedDate;
    private String assignedTo;
    private List<String> tags = new ArrayList<>();
    private List<Comment> comments = new ArrayList<>();

    public Issue(String title, String description, Priority priority, String assignedTo) {
        this.id = counter++;
        this.title = title;
        this.description = description;
        this.priority = priority;
        this.status = Status.OPEN;
        this.creationDate = new Date();
        this.lastModifiedDate = new Date();
        this.assignedTo = assignedTo;
    }

    public void update(String title, String description, Priority priority, String assignedTo) {
        this.title = title;
        this.description = description;
        this.priority = priority;
        this.assignedTo = assignedTo;
        this.lastModifiedDate = new Date();
    }

    public void changeStatus(Status newStatus) {
        this.status = newStatus;
        this.lastModifiedDate = new Date();
    }

    public void addComment(Comment comment) {
        this.comments.add(comment);
    }

    public int getId() { return id; }
    public Status getStatus() { return status; }

    public String getDescription() {return description;}

}
