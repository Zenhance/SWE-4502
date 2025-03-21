import java.util.HashMap;
import java.util.Map;

public class IssueRepository {

    public Map<String,Issue> issues= new HashMap<>();

    public void addIssue(Issue issue){
        issues.put(String.valueOf(issue.getId()),issue);
    }


    public Issue getIssue(String id){
        return issues.get(id);
    }

    public String AddComment(String id, Comment comment){
        Issue issue=issues.get(id);
        issue.comments.add(comment);
        return "Comment added successfully";
    }


    public void updateIssue(String id, Issue issue){
        issues.put(id,issue);
    }

    public void ChangeIssueStatus(String id, Status status){
        Issue issue=issues.get(id);
        issue.status=status;
    }








    
}
