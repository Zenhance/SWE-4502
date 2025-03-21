import java.util.HashMap;
import java.util.Map;

public class IssueRepository {

    private final Map<Integer, Issue> issues = new HashMap<>();

    public void addIssue(Issue issue) {

        issues.put(issue.getId(), issue);
    }
    public Issue getIssue(int id){
        return issues.get(id);
    }

}