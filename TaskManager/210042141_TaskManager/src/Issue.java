import java.util.Date;
import java.util.List;

public class Issue
{
    public int id;
    public String title;
    public String description;
    public String priority;
    public String status;
    public String assignedTo;
    public Date creationDate;
    public Date lastModifiedDate;
    public List<String> tags;
    public List<Comment> comments;

    public Issue(int id, String title, String description, String priority, String status, Date creationDate, Date lastModifiedDate, String assignedTo, List<String> tags, List<Comment> comments){
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

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public String getPriority() { return priority; }
    public void setPriority(String priority) { this.priority = priority; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = "InProgress"; }



    public List<String> getTags() { return tags; }
    public void setTags(List<String> tags) { this.tags = tags; }

    public List<Comment> getComments() { return null; }
    public void setComments(List<Comment> comments) { this.comments = comments; }

}


