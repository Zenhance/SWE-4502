import java.time.LocalDateTime;
import java.util.*;

public class Issue {


IssueRepository i= new IssueRepository();
    HashMap<String, Issue> issues = i.getList();
    private String id;
    private String title;
    private String description;

    private LocalDateTime creationDate;
    private LocalDateTime lastModifiedDate;
    private String assignedTo;
    private String tags;
    private Priority priority;
    private Status status;


    public Issue(String title, String description, Priority priority) {
        this.id=UUID.randomUUID().toString();
        this.title = title;
        this.description = description;
        this.priority = priority;
        this.status = Status.Open;
        this.creationDate = LocalDateTime.now();
        this.lastModifiedDate = LocalDateTime.now();
    }

   List<Comment> comments=new ArrayList<>();

    public String getId() {
        return id;
    }



//    public void createIssue(int _id, String _title, String _description){
//      if((!issues.containsKey(_id))||(issues.isEmpty())){
//          Issue issue=new Issue(_title,_description);
//          issues.put(_id,issue);
//          System.out.println("The issue has been created successfully");
//      }
//      else{
//          System.out.println("The issue with similar id has been found");
//      }
//
//
//    }




    public void changeStatus(Status status) {
        this.status = status;
        updateModifiedDate();
    }



    private void updateModifiedDate() {
        this.lastModifiedDate = LocalDateTime.now();
    }

    public Status getStatus() { return status; }

}