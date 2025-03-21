package Lab_final_210042166.Task_Management_System.Issue_Repository;
import Lab_final_210042166.Task_Management_System.Issue.Issue;

import java.util.HashMap;
import java.util.Map;


public class IssueRepository {
    private static IssueRepository instance;
    private Map<String, Issue> issues;

    private IssueRepository() {
        issues = new HashMap<>();
    }

    public static IssueRepository getInstance() {
        if (instance == null) {
            instance = new IssueRepository();
        }
        return instance;
    }

    public void addIssue(Issue issue) {
        issues.put(issue.getId(), issue);
    }

    public Issue getIssue(String id) {
        return issues.get(id);
    }

    public void updateIssue(Issue issue) {
        issues.put(issue.getId(), issue);
    }

    public void removeIssue(String id) {
        issues.remove(id);
    }
}


