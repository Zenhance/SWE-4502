import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class IssueRepository {

    private Map<UUID, Issue> issues =new HashMap<>();

    public void addIssue(Issue issue){issues.put(issue.getId(), issue);}

    public Issue getIssue(int id){return issues.get(id);}

    public void updateIssue(Issue issue){return;}

    public void removeIssue(Issue issue){return;}



}
