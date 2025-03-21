import java.util.HashMap;
import java.util.Map;

public class IssueRepository {
    private Map<String,Issue>issues;

    public IssueRepository(){
        this.issues=new HashMap<>();
    }

    public void addIssue(Issue issue){
        issues.put(issue.getId(),issue);
    }

    public Issue getIssue(String id){
        return issues.get(id);
    }

    public Issue removeIssue(String id)
    {
        return issues.remove(id);
    }

    public Map<String,Issue> getAllIssues(){
        return issues;
    }


}