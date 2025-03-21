import java.util.HashMap;
import java.util.Map;

public class IssueRepository {

    private final Map<Integer, Issue> issues = new HashMap<>();
    static int nextId = 12345;

    public void addIssue(Issue issue) {
        issues.put(nextId, issue);
        nextId++;
    }
    public Issue getIssue(int id){
        return issues.get(id);
    }

}