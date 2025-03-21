import java.security.PublicKey;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Issue implements  Task {
    public int Id;
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
    public Issue clone() {
        return new Issue();
    }

    @Override
    public void performAction() {
        System.out.println("Performing action" + description);

    }
}
