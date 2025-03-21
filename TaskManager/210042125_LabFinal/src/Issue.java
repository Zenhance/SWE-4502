import java.util.ArrayList;
import java.util.Date;

public class Issue {

    private String Id;
    private String Title;
    private String Description;
    private Priority Priority;
    private Status Status;
    private Date CreationDate;
    private Date LastModifiedDate;
    private String AssignedTo;
    private String Tags[];
    private ArrayList<Comment> CommentList;
    private ArrayList<String> LogHistory;

    public Issue(){
        CommentList= new ArrayList<>();
    }

    public String getID(){
        return Id;
    }

    public void updateIssue(String Title){
        this.Title= Title;
    }

    public void updateIssue(String Title, String Description){
        this.Title= Title;
        this.Description= Description;
    }

    public void changeStatus(Status status){
        this.Status= status;
    }

    public void addComment(Comment comment){
        CommentList.add(comment);
    }

    public void logOperation(){

    }
}
