package models;

import java.security.Timestamp;
import java.sql.Time;
import java.time.LocalDateTime;
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
    private List<String> tags;
    private List<Comment> comments;

    public void setId(String id){
        this.id = id;
    }
    public void setTitle(String title){
        this.title = title;
    }
    public void setDescription(String description){
        this.description = description;
    }

    public void setPriority(Priority priority){
        this.priority = priority;
    }
    public void setStatus(Status status){
        this.status = status;
    }
    public void setCreationDate(LocalDateTime creationDate){
        this.creationDate = creationDate;
    }
    public void setLastModifiedDate(LocalDateTime lastModifiedDate){
        this.lastModifiedDate = lastModifiedDate;
    }

    public void setAssignedTo(String assignedTo){
        this.assignedTo = assignedTo;
    }

    public String getId(){
        return id;
    }

    public String getTitle(){
        return title;
    }
    public Status getStatus(){
        return  status;
    }
    public Priority getPriority(){
        return priority;
    }
    public String getDescription(){
        return description;
    }
    public List<Comment> getComments(){ return comments; }
}
