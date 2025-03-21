package repository;

import model.Issue;

import java.util.HashMap;
import java.util.Map;

public class IssueRepository {
    private static IssueRepository instance;
    private final Map<String, Issue> issues;

    private IssueRepository() {
        this.issues = new HashMap<>();
    }

    public static synchronized IssueRepository getInstance() {
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

    public Map<String, Issue> getAllIssues() {

        return new HashMap<>(issues);
    }

    public boolean containsIssue(String id) {

        return issues.containsKey(id);
    }

    public int getIssueCount() {

        return issues.size();
    }
}