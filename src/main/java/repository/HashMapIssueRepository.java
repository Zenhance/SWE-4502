package repository;

import models.Issue;
import models.Status;
import java.util.*;
import java.util.stream.Collectors;

public class HashMapIssueRepository implements IssueRepository {
    private final Map<String, Issue> issues;

    public HashMapIssueRepository() {
        this.issues = new HashMap<>();
    }

    @Override
    public Issue save(Issue issue) {
        if (issue == null) {
            throw new IllegalArgumentException("Issue cannot be null");
        }
        if (issue.getId() == null || issue.getId().trim().isEmpty()) {
            throw new IllegalArgumentException("Issue ID cannot be null or empty");
        }
        issues.put(issue.getId(), issue);
        return issue;
    }

    @Override
    public Optional<Issue> findById(String id) {
        if (id == null || id.trim().isEmpty()) {
            throw new IllegalArgumentException("ID cannot be null or empty");
        }
        return Optional.ofNullable(issues.get(id));
    }

    @Override
    public List<Issue> findAll() {
        return new ArrayList<>(issues.values());
    }

    @Override
    public List<Issue> findByStatus(Status status) {
        if (status == null) {
            throw new IllegalArgumentException("Status cannot be null");
        }
        return issues.values().stream()
                .filter(issue -> issue.getStatus() == status)
                .collect(Collectors.toList());
    }

    @Override
    public List<Issue> findByAssignee(String assignee) {
        if (assignee == null || assignee.trim().isEmpty()) {
            throw new IllegalArgumentException("Assignee cannot be null or empty");
        }
        return issues.values().stream()
                .filter(issue -> assignee.equals(issue.getAssignedTo()))
                .collect(Collectors.toList());
    }

    @Override
    public void delete(String id) {
        if (id == null || id.trim().isEmpty()) {
            throw new IllegalArgumentException("ID cannot be null or empty");
        }
        if (!issues.containsKey(id)) {
            throw new NoSuchElementException("Issue not found with ID: " + id);
        }
        issues.remove(id);
    }

    @Override
    public boolean exists(String id) {
        if (id == null || id.trim().isEmpty()) {
            throw new IllegalArgumentException("ID cannot be null or empty");
        }
        return issues.containsKey(id);
    }

    @Override
    public void update(Issue issue) {
        if (issue == null) {
            throw new IllegalArgumentException("Issue cannot be null");
        }
        if (issue.getId() == null || issue.getId().trim().isEmpty()) {
            throw new IllegalArgumentException("Issue ID cannot be null or empty");
        }
        if (!issues.containsKey(issue.getId())) {
            throw new NoSuchElementException("Issue not found with ID: " + issue.getId());
        }
        issues.put(issue.getId(), issue);
    }

    // Additional utility methods
    public void clear() {
        issues.clear();
    }

    public int count() {
        return issues.size();
    }
} 