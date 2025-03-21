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
    private List<String> tags;
    private List<Comment> comments;
}
