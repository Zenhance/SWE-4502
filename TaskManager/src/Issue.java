import jdk.jshell.Snippet;

import java.security.PublicKey;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Issue  {
    public int Id;
    public List<Comment> commentList =new ArrayList<>();
    public String title;
    public String description;
    public Priority priority;
    public Status status;
    public Date CreationDate;
    public Date LastModifiedDate;
    public String Assignedto;
    public String Tags[];



    public Issue(int id, String title, String description, Priority priority) {
        this.Id = id;
        this.title = title;
        this.description = description;
        this.priority = priority;
        this.status = Status.Open;
        this.CreationDate = new Date();
        this.LastModifiedDate = CreationDate;
    }


    public void UpdateIssue(String title, String description, Priority p) {
        this.title = title;
        this.description = description;
        this.priority = p;
        this.LastModifiedDate = new Date();
    }
    public void changeStatus(Status status) {
        this.status = status;
        this.LastModifiedDate = new Date();
    }
    public void addComment(Comment comment) {
        commentList.add(comment);
        this.LastModifiedDate = new Date();
    }

    public Status getStatus()
    { return status; }


    public Integer getId() {
        return Id;
    }
}