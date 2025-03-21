import java.util.*;

public class IssueRepository {
    private Map<String, Issue> issues = new HashMap<>();


    public void addIssue(Issue issue) {
        issues.put(issue.getId(), issue);
    }


    public Issue getIssue(String id) {
        return issues.get(id);
    }


    public void updateIssue(String id, Issue updatedIssue) {
        issues.put(id, updatedIssue);
    }


    public void deleteIssue(String id) {
        issues.remove(id);
    }


    public List<Issue> getAllIssues() {
        return new ArrayList<>(issues.values());
    }
}