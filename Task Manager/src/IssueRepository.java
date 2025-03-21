import java.util.HashMap;
import java.util.Map;

public class IssueRepository {
    private Map<String, Issue> issueMap;

    public IssueRepository() {
        issueMap = new HashMap<>();
    }

    public void addIssue(Issue issue) {
        issueMap.put(issue.getId(), issue);
    }

    public void updateIssue(Issue issue) {
        issueMap.put(issue.getId(), issue);
    }

    public void removeIssue(Issue issue) {
        issueMap.remove(issue.getId());
    }

    public Issue getIssueById(String id) {
        return issueMap.get(id);
    }

    public Map<String, Issue> getAllIssues() {
        return issueMap;
    }
}
