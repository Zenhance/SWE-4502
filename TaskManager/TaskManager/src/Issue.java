import java.util.Date;
import java.util.ArrayList;
import java.util.List;

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

    public Issue create(){
        return new Issue();
    }

    public void update(String property){
        this.property=property;
    }
    public void changeStatus(){
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
    public void addComment(Comment comment){
        comments.add(comment);
    }
}