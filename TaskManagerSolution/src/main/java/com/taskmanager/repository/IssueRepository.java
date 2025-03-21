package main.java.com.taskmanager.repository;

import main.java.com.taskmanager.model.Issue;
import java.util.HashMap;
import java.util.Map;

public class IssueRepository {
    private Map<String, Issue> issues = new HashMap<>();

    public void addIssue(Issue issue) {
        issues.put(issue.getId(), issue);
    }

    public Issue getIssue(String id) {
        return issues.get(id);
    }

    public void updateIssue(Issue issue) {
        issues.put(issue.getId(), issue);
    }

    public void deleteIssue(String id) {
        issues.remove(id);
    }
}

