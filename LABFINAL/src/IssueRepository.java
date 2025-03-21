import java.util.HashMap;
import java.util.Map;

public class IssueRepository {
    private Map<Integer, Issue> issues = new HashMap<>();

    public void addIssue(Issue issue) {
        issues.put(issue.getId(), issue);
    }
    public void removeIssue(Issue issue){
        issues.remove(issue.getId());
    }

    public Issue getIssue(int id) {
        return issues.get(id);
    }
}