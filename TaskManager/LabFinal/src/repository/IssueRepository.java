package repository;
import model.Issue;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class IssueRepository {
    private Map<String, Issue> issues = new HashMap<>();

    public void save(Issue issue) {
        issues.put(issue.getId(), issue.clone());
    }
    public Issue findById(String id) {
        Issue issue = issues.get(id);
        return issue != null ? issue.clone() : null;
    }
    public List<Issue> findAll() {
        return issues.values().stream().map(Issue::clone).collect(Collectors.toList());
    }
    public void delete(String id) {
        issues.remove(id);
    }
    public boolean existsById(String id) {
        return issues.containsKey(id);
    }
    public int count() {
        return issues.size();
    }
}
