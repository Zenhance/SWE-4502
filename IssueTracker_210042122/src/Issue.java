import Predefinedvalues.Priority;
import Predefinedvalues.Status;

import java.sql.Date;
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

    private  List<Comment> comments;


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
