import java.util.HashMap;
import java.util.Map;

public class IssueRepository {
    private Map<Integer, Issue> issues;

    public IssueRepository() {
        issues = new HashMap<>();
    }

    public void addIssue(Issue issue) {
        issues.put(issue.ID, issue);
    }

    public Issue getIssue(int id) {
        return issues.get(id);
    }

    public void removeIssue(int id) {
        issues.remove(id);
    }

    public Map<Integer, Issue> getAllIssues() {
        return issues;
    }
}