import java.util.Date;
import java.util.HashMap;

public class Issue {


IssueRepository i= new IssueRepository();
    HashMap<Integer, Object>issues = i.getList();
    private int id;
    private String title;
    private String description;

    private Date CreationDate;
    private Date LastModifiedDate;
    private String AssignedTo;
    private String Tags;

    public Issue( String title, String description) {

        this.title=title;
        this.description=description;


    }

    enum Comments {
        Id,
        Content,
        Author,
        CreatedAt
    }
    enum  Priority{
        Low,Medium,High,Critical
    }
    enum Status{
        Open, InProgress, UnderReview, Resolved, Closed
    }

    public short createIssue(int _id, String _title, String _description){
      if((!issues.containsKey(_id))||(issues.isEmpty())){
          Issue issue=new Issue(_title,_description);
          issues.put(_id,issue);
          System.out.println("The issue has been created successfully");
      }
      else{
          System.out.println("The issue with similar id has been found");
      }

        return 0;
    }
    public void updateIssue(){

    }



}
