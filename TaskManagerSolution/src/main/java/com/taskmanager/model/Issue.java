package main.java.com.taskmanager.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Date;

public class Issue {
    private String id;
    private String title;
    private String description;
    private Priority priority;
    private Status status;
    private Date createdDate;
    private Date lastModifiedDate;
    private String assignedTo;
    private List<String> tags = new ArrayList<>();
    private List<Comment> comments = new ArrayList<>();

    public Issue(String id, String title, String description, Priority priority, Status status, Date createdDate,
                 Date lastModifiedDate, String assignedTo, List<String> tags, List<Comment> comments) {
        this.id=id;
        this.title=title;
        this.description=description;
        this.priority=priority;
        this.status=status;
        this.createdDate=createdDate;
        this.lastModifiedDate=lastModifiedDate;
        this.assignedTo=assignedTo;
        this.tags=tags;
        this.comments=comments;}


    public String getId() {
        return id;
    }
}


