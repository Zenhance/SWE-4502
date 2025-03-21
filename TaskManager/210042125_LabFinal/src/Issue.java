import java.util.ArrayList;
import java.util.Date;

public class Issue implements Notify, Clonify{

    private String Id;
    private String Title;
    private String Description;
    private Priority Priority;
    private Status status;
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
        this.status= Status.Open;
        notifying("New Status created with "+this.getID());
    }

    public String getStatus(){
        return status.toString();
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

    public boolean getComment(Comment comment){
        if(CommentList.contains(comment)){
            return true;
        }
        else{
            return false;
        }
    }

    public void updateIssue(String Title){
        this.Title= Title;
    }

    public void updateIssue(String Title, String Description){
        this.Title= Title;
        this.Description= Description;
    }

    public void changeStatus(Status status){
        Status s= this.status;
        notifying("Status changed from "+this.status+" to "+status);
        this.status= status;
        Status s2= this.status;

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

    @Override
    public Issue clone() {
        return new Issue(this.Title, this.Description, this.Priority);
    }

    public String getDetails(){
        String s1= Description+ Priority+ Title;
        return s1;
    }
}
