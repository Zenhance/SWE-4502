package repository;

import models.Issue;
import java.util.List;
import java.util.Optional;

public interface IssueRepository {
    Issue save(Issue issue);
    Optional<Issue> findById(String id);
    List<Issue> findAll();
    List<Issue> findByStatus(models.Status status);
    List<Issue> findByAssignee(String assignee);
    void delete(String id);
    boolean exists(String id);
    void update(Issue issue);
} 