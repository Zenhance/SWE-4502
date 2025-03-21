import java.util.HashMap;
import java.util.Map;

public class IssueRepository {
    private Map<Integer, Issue> issueMap = new HashMap<>();

    public void addIssue(Issue issue){
        issueMap.put(issue.getId(), issue);
    }

    public Issue getIssue(int id){
        return issueMap.get(id);
    }

    public void removeIssue(int id){
        issueMap.remove(id);
    }
}
