package models;

import java.security.Timestamp;
import java.util.List;

public class Issue {
    private String id;
    private String title;
    private String description;
    private Priority priority;
    private Status status;
    private Timestamp creationDate;
    private Timestamp lastModifiedDate;
    private String assignedTo;
    private List<String> tags;
    private List<Comment> comments;

    public String getId(){
        return id;
    }

    public String getTitle(){
        return title;
    }
}
