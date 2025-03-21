import java.util.*;

class Issue {
    enum Priority { LOW, MEDIUM, HIGH, CRITICAL }
    enum Status { OPEN, IN_PROGRESS, UNDER_REVIEW, RESOLVED, CLOSED }

    private static int counter = 1;

    int id;
    String title;
    String description;
    Priority priority;
    Status status;
    Date creationDate;
    Date lastModifiedDate;
    String assignedTo;
    List<String> tags;
    List<Comment> comments;

    public Issue(String title, String description, Priority priority) {
        this.id = counter++;
        this.title = title;
        this.description = description;
        this.priority = priority;
        this.status = Status.OPEN;
        this.creationDate = new Date();
        this.lastModifiedDate = new Date();
        this.tags = new ArrayList<>();
        this.comments = new ArrayList<>();
    }

    public void addComment(Comment comment) {
        this.comments.add(comment);
        this.lastModifiedDate = new Date();
    }
}


