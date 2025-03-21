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
    List<Comment>Comments=new ArrayList<>();

    public Issue(int Id,String Title,String Description,Status status,Priority pririty,Date CreationDate,Date LastModifiedDate,String AssignedTo,List<String>Tags,List<Comment>Comments){
        this.Title=Title;
        this.Description=Description;
        this.priority=pririty;
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
                status=Open;
                break;
            case InProgress:
                status=InProgress;
                break;
            case UnderReview:
                status=UnderReview;
                break;
            case Resolved:
                status=Resolved;
                break;
            case Closed:
                status=Closed;
                break;
            default:
                status=Open;
                break;
        }
    }
    public void addComment(Comment comment)
        comments.add(comment);
    }
}