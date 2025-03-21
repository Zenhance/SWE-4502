import java.util.HashMap;
import java.util.Map;

public class IssueRepository {
    private final Map<String,Issue> issues = new HashMap<>();

    public void addIssue(Issue issue) {
        issues.put(issue.getId(), issue);
    }

    public Issue getIssue(String id) {
        return issues.get(id);
    }

    public void removeIssue(String id) {
        issues.remove(id);
    }

    public void updateIssue(Issue issue) {
        if (issues.containsKey(issue.getId())) {
            issues.put(issue.getId(), issue);
        }
    }
}
