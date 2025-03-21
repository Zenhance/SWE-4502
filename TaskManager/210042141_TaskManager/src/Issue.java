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

    public int getId(){
        return id;
    }

    public void setId(int id){
        this.id = id;
    }

    public void getTitle(){
        return title;
    }


}


