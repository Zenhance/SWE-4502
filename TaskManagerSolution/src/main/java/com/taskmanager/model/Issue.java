package com.taskmanager.model;

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
    private List<String> tags = new ArrayList<String>();
    private List<Comment> comments = new ArrayList<Comment>();

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

    public Issue() {

    }

    public String getId() {
        return id;
    }public void setId(String id) {
        this.id = id;
    }
    public String getTitle() {

        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;}

    public void setDescription(String description) {
        this.description = description;}
    public Priority getPriority() {
        return priority;
    }public void setPriority(Priority priority) {
        this.priority = priority;
    }
    public Status getStatus() {
        return status;
       }
       public void setStatus(Status status) {
        this.status = status;
       }

    public Date getCreatedDate() {
        return createdDate;
        }

    public void setCreatedDate(Date createdDate) {
        this.createdDate=createdDate;
    }

    public Date getLastModifiedDate() {
        return lastModifiedDate;
    }
    public void setLastModifiedDate(Date lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }

    public String getAssignedTo() {
        return assignedTo;
    }

    public void setAssignedTo(String assignedTo) {
        this.assignedTo = assignedTo;
    }

    public List<String> getTags() {return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    public List<Comment> getComments() {return comments;
    }

    public void setComments(List<Comment> comments) {this.comments = comments;
    }
}


