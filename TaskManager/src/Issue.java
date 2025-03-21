import java.util.*;
public class Issue {
    private String id;
    private String title;
    private String description;
    private Priority priority;

    private Status status;
    private Date creationDate;
    private Date lastModifiedDate;
    private String assignedTo;
    private List<String> tags;
    private List<Comment> comments;

    public Issue(String id, String title, String description, Priority priority, String assignedTo, List<String> tags) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.priority = priority;
        this.status = Status.OPEN;
        this.creationDate = new Date();
        this.lastModifiedDate = new Date();
        this.assignedTo = assignedTo;
        this.tags = tags;
        this.comments = new ArrayList<>();
    }
    public String getId()
    {
        return id;
    }
    public String getTitle()
    {
        return title;
    }
    public void setTitle(String title)
    {
        this.title = title;
    }
    public String getDescription()
    {
        return description;
    }
    public void setDescription(String description)
    {
        this.description = description;
    }
    public Priority getPriority()
    {
        return priority;
    }
    public void setPriority(Priority priority)
    {
        this.priority = priority;
    }
    public Status getStatus()
    {
        return status;
    }
    public void setStatus(Status status)
    {
        this.status = status;
    }
    public Date getCreationDate()
    {
        return creationDate;
    }
    public Date getLastModifiedDate()
    {
        return lastModifiedDate;
    }
    public void setLastModifiedDate(Date lastModifiedDate)
    {
        this.lastModifiedDate = lastModifiedDate;
    }
    public String getAssignedTo()
    {
        return assignedTo;
    }
    public void setAssignedTo(String assignedTo)
    {
        this.assignedTo = assignedTo;
    }
    public List<String> getTags()
    {
        return tags;
    }
    public void setTags(List<String> tags)
    {
        this.tags = tags;
    }
    public List<Comment> getComments()
    {
        return comments;
    }
    public void addComment(Comment comment)
    {
        this.comments.add(comment);
    }


}
