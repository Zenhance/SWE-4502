import java.util.HashMap;
import java.util.Map;

public class IssueRepo {

        private final Map<String, Issue> issues = new HashMap<>();

        public void addIssue(Issue issue) { issues.put(issue.getId(), issue); }
        public Issue getIssue(String ID) { return issues.get(ID); }
        public void remove(String ID) { issues.remove(ID); }

}




