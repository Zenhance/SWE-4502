import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Issue {

    public String Id;

    public String Title;

    public String Description;

    public Priority Priority;

    public  Status status;

    public LocalDateTime Creationdate;

    public LocalDateTime LastModifiedDate;

    public String AssignedTo;

    public List<String> Tags=new ArrayList<>();

    public List<Comment> comments=new ArrayList<>();


    public Issue (String ID,String Title,String Description,Priority Priority, Status Status,LocalDateTime Creationdate,LocalDateTime LastModifiedDate, String assignedTo ,List<Comment> comments,List<String>tags ){

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


    public String getId() {
        return Id;
    }






























}
