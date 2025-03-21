import java.util.*;
public class IssueRepository{
    public int Id;
    HashMap<int,Issue>issues=new HashMap<>();
    public bool creation=false;

    public void create(int Id, Issue issue){
        issues.put(Id,issue);
        creation=true;
    }
    public boolean getCreation(){
        return creation;
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
    public void addComment(Comment comment){
        comments.add(comment);
    }
}