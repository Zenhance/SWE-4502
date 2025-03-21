package Lab_Final_210042150.Task_Management_System.Repositories;

import Lab_Final_210042150.Task_Management_System.Models.DomainModel.Issue;
import java.util.Map;
import java.util.HashMap;
import java.util.Optional;
import java.util.Collection;


public class IssueRepository {
    private final Map<String, Issue> issues = new HashMap<>();

    public void save(Issue issue)
    {
        issues.put(issue.getId(),issue.clone());
    }

    public Optional<Issue> findById(String id)
    {
        return Optional.ofNullable(issues.get(id)).map(Issue::clone);
    }

    public Collection<Issue> findAll() {
        return issues.values().stream().map(Issue::clone).toList();
    }

    public void delete(String id) {
        issues.remove(id);
    }

    public int count() {
        return issues.size();
    }
}
