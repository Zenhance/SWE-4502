import java.util.ArrayList;
import java.util.Date;

public class Issue implements Notify{

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
    private ArrayList<Log> LogHistory;
    private ArrayList<User> SubscriberList;

    public Issue(String Title, String Description, Priority priority){
        this.Title= Title;
        this.Description= Description;
        this.Priority= priority;
        CommentList= new ArrayList<>();
        SubscriberList= new ArrayList<>();
        notifying("New Status created with "+this.getID());
    }

    public String getID(){
        return Id;
    }

    public String getDescription(){
        return Description;
    }
    public String getTitle(){
        return Title;
    }
    public Priority getPriority(){
        return Priority;
    }

    public void updateIssue(String Title){
        this.Title= Title;
    }

    public void updateIssue(String Title, String Description){
        this.Title= Title;
        this.Description= Description;
    }

    public void changeStatus(Status status){
        notifying("Status changed from "+this.Status+" to "+status);
        this.Status= status;
    }

    public void addComment(Comment comment){
        CommentList.add(comment);
    }

    public void AccessLogHistory(){
        for(Log a: LogHistory){
            System.out.println("Log Description: "+a.getDescription()+" Log Created At: "+a.getCreatedAt());
        }
    }

    public void AddSubscriber(User a){
        SubscriberList.add(a);
    }

    public void removeSubscriber(User a){
        SubscriberList.remove(a);
    }

    @Override
    public void notifying(String s) {
        for(User a: SubscriberList){
            a.receiveNotification(s);
        }
    }
}
