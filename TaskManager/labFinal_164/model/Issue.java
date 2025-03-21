package labFinal_164.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Issue {
    private String id;
    private String title;
    private String description;
    private Priority priority;
    private Status status;
    private LocalDateTime creationDate;
    private LocalDateTime lastModifiedDate;
    private String assignedTo;
    private List<Comment> comments = new ArrayList<>();

    public Issue(String id, String title, String description, Priority priority ) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.priority = priority;
        this.status = Status.OPEN;
        this.creationDate = LocalDateTime.now();
        this.lastModifiedDate = creationDate;

    }


    public String getId() {
        return id;
    }
}
