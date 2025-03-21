package Class;

import Predefinedvalues.Priority;
import Predefinedvalues.Status;

import java.util.List;

public class Issue {
    private int id;
    private String title;
    private String description;

    private Priority priority;

    private Status status;

    private String creationDate;

    private String lastModifiedDate;

    private String assignedTo;

    private List<String> tags;

    public List<Comment> comments;


    public Issue(int id, String title, String description, Priority priority, Status status, String creationDate, String lastModifiedDate, String assignedTo, List<String> tags, List<Comment> comments) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.priority = priority;
        this.status = status;
        this.creationDate = creationDate;
        this.lastModifiedDate = lastModifiedDate;
        this.assignedTo = assignedTo;
        this.tags = tags;
        this.comments = comments;
    }

    public Issue(String title, String description,Priority priority){
        this.title=title;
        this.description=description;
        this.priority=priority;
        this.status=Status.Open;
    }

    public void addComment(Comment C){
        comments.add(C);

    }



    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public Priority getPriority() {
      return  priority;
    }

    public int getId() {
        return id;
    }
}
