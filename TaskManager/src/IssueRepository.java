import java.util.HashMap;
import java.util.Map;

public class IssueRepository {
    private Map<Integer, Issue> issues = new HashMap<>();


    public void addIssue(Issue issue) {

        if (issue != null && !issues.containsKey(issue.getId())) {
            issues.put(issue.getId(), issue);
        }
    }


    public Issue getIssue(int id) {
        return issues.get(id);
    }


    public void updateIssue(Issue issue) {
        if (issue != null && issues.containsKey(issue.getId())) {
            issues.put(issue.getId(), issue);
        }
    }


    public void removeIssue(int id) {
        issues.remove(id);
    }


    public Map<Integer, Issue> getAllIssues() {
        return new HashMap<>(issues);
    }
}
