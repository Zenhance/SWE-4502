import java.security.PublicKey;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Issue implements  Receiver {
    public int Id=0;
    public List<Comment> commentList =new ArrayList<>();
    public String title;
    public String description;
    public Priority priority;
    public Status status;
    public Date CreationDate;
    public Date LastModifiedDate;
    public String Assignedto;
    public String Tags[];








    @Override
    public void CreateIssue(IssueRepository r) {

       r.hm1.put(Id,new Issue());
       Id++;
       System.out.println("Issue " + Id +"has been created");
    }

    @Override
    public void UpdateIssue(String description) {
        this.description=description;

    }

    @Override
    public void ChangeStatus(Priority p) {
        this.priority=p;

    }

    @Override
    public void Addcomments(Comment c) {
        commentList.add(c);

    }

    @Override
    public void LogOperation() {

    }

    @Override
    public void TriggerNotification() {

    }

    @Override
    public void StatisticController() {

    }
}
