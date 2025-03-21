import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

public class Issue {

    public int Id;

    public String Title;

    public String Description;

    public Priority Priority;

    public  Status status;

    public LocalDateTime Creationdate;

    public LocalDateTime LastModifiedDate;

    public String AssignedTo;

    public List<String> Tags;

    public List<Comment> comments;


    public Issue (int ID,String Title,String Description,Priority Priority, Status Status,LocalDateTime Creationdate,LocalDateTime LastModifiedDate, String assignedTo ,List<Comment> comments,List<String>tags ){

        this.Id=ID;
        this.Title=Title;

        this.Description=Description;

        this.Priority=Priority;

        this.status=Status;

        this.Creationdate=Creationdate;
        this.LastModifiedDate=LastModifiedDate;
        this.AssignedTo=assignedTo;
        this.comments=comments;

        this.Tags=tags;







    }



    public void addComment(Comment comment) {
        this.comments.add(comment);

    }
















}
