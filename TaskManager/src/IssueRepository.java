import java.util.HashMap;
import java.util.Map;

public class IssueRepository {
    private final Map<Integer, Issue> issues = new HashMap<>();
    private int nextId = 1;
    public void addIssue(Issue issue) {
        issues.put(issue.getId(), issue);
    }
    public Issue getIssue(int id) {
        return issues.get(id);
    }
    public void removeIssue(int id) {
        issues.remove(id);
    }
    public int getIssueCount() {
        return issues.size();
    }

}
