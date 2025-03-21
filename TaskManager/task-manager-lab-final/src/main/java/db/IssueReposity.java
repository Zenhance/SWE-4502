package db;

import java.util.*;
import java.util.Map;

import models.Issue;

public class IssueReposity {
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

    public void removeIssue(Issue issue) {
        issues.remove(issue.getId());
    }
    public List<Issue> getAllIssues() {
        return new ArrayList<>(issues.values());
    }


}
