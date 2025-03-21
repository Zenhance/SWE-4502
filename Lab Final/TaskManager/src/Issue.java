import java.util.ArrayList;
import java.util.Date;
import java.util.List;
public class Issue {
    public int ID;
    public String title;
    public String description;
    public String status;
    public String priority;
    public String assignee;
    public Date LastModified;
    public Date CreatedAt;
    public List<Comment> comments;
    public List<String> tags;

    public Issue(int ID, String title, String description, String status, String priority, String assignee, Date LastModified, Date CreatedAt, List<Comment> comments, List<String> tags) {
        this.ID = ID;
        this.title = title;
        this.description = description;
        this.status = status;
        this.priority = priority;
        this.assignee = assignee;
        this.LastModified = LastModified;
        this.CreatedAt = CreatedAt;
        this.comments = comments != null ? comments : new ArrayList<>();
        this.tags = tags;
    }

    public void addComment(Comment comment) {
        comments.add(comment);
    }

    public void addAssignee(String assignee) {
        this.assignee = assignee;
    }

}
