import java.util.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Issue{
    public int Id;
    public String Title;
    public String Description;
    private Status status;
    private Priority priority;
    public Date CreationDate;
    public Date LastModifiedDate;
    public String AssignedTo;
    List<String>Tags=new ArrayList<>();
    List<Comment>comments=new ArrayList<>();
    public String property;

    public Issue(String Title,String Description,Priority priority){
        this.Title=Title;
        this.Description=Description;
        this.priority=priority;
    }
    public int getId(){
        return Id;
    }
    public void update(String property){
        this.property=property;
    }
    public void changeStatus(Status status){
        switch(status){
            case Open:
                status= Status.Open;
                break;
            case InProgress:
                status= Status.InProgress;
                break;
            case UnderReview:
                status= Status.UnderReview;
                break;
            case Resolved:
                status= Status.Resolved;
                break;
            case Closed:
                status= Status.Closed;
                break;
            default:
                status= Status.Open;
                break;
        }
    }
    public void addComment(Comment comment){
        comments.add(comment);
    }
}