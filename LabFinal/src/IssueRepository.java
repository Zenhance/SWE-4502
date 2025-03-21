import java.util.*;

public class IssueRepository {
    private Map<Integer, Issue> issues = new HashMap<>();

    public void addIssue(Issue issue) {
        issues.put(issue.getId(), issue);
    }

    public Issue getIssue(Integer id) {
        return issues.get(id);
    }

    public void updateIssue(Issue issue) {
        issues.put(issue.getId(), issue);
    }

    public void removeIssue(Integer id) {
        issues.remove(id);
    }

    public Collection<Issue> getAllIssues() {
        return issues.values();
    }
}
