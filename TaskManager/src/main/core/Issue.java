package main.core;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

enum Priority {
    Low,
    Medium,
    High,
    Critical
}

enum Status {
    Open,
    InProgress,
    UnderReview,
    Resolved,
    Closed
}
  

public class Issue {

    private String id;
    private String title;
    private String description;
    private Priority priority;
    private Status status;
    private LocalDate creationDate;
    private LocalDate lastModifiedDate;
    private String assignedTo;
    private List<String> tags;
    private List<Comment> comments;

    public Issue(String _title, String _description, String _assignedTo) {
        UUID uuid = UUID.randomUUID();
        this.id = uuid.toString();
        this.title = _title;
        this.description = _description;
        this.priority = Priority.Low;
        this.status = Status.Open;
        this.creationDate = LocalDate.now();
        this.lastModifiedDate = LocalDate.now();
        this.assignedTo = _assignedTo;
        this.tags = new ArrayList<>();
        this.comments = new ArrayList<>();
    }

    public Issue(Issue target) {
        if (target != null) {
            this.title = target.title;
            this.description = target.description;
            this.assignedTo = target.assignedTo;
        }
    }

    public Issue clone() {
        return new Issue(this);
    }

    public String GetId() {
        return id;
    }

    public String GetTitle() {
        return this.title;
    }

    public void UpdateTitle(String _newTitle) {
        this.title = _newTitle;
    }

    public String GetDescription() {
        return this.description;
    }

    public void UpdateDescription(String _newDescription) {
        this.description = _newDescription;
    }

    public LocalDate GetCreationDate() {
        return this.creationDate;
    }

    public List<Comment> GetComments() {
        return this.comments;
    }

    public void AddComment(Comment _comment) {
        this.comments.add(_comment);
    }

    public List<String> GetTags() {
        return this.tags;
    }

    public void AddTag(String _tag){
        this.tags.add(_tag);
    }

    public Priority GetPriority() {
        return this.priority;
    }

    public void SetPriority(Priority _priority){
        this.priority = _priority;
    }

    public Status GetStatus() {
        return this.status;
    }

    public void SetStatus(Status _status){
        this.status = _status;
    }

    public LocalDate GetLastModifiedDate() {
        return lastModifiedDate;
    }

    public void SetLastModifiedDate(LocalDate _newTime) {
        this.lastModifiedDate = _newTime;
    }

    public String GetAssignedTo(){
        return this.assignedTo;
    }

    public void UpdateAssignedTo(String _newAssignedTo) {
        this.assignedTo = _newAssignedTo;
    }
}
