import java.util.HashMap;
import java.util.Map;

public class IssueRepo {

    private Map<Integer, Issue> issues = new HashMap<>();

    public void addIssue(Issue issue) {
        issues.put(issue.getId(), issue);
    }

    public Issue getIssue(int ID) {
        return issues.get(ID);
    }
}





