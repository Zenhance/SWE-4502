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
}
