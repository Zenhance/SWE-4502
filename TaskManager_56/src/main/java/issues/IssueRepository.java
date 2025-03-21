package issues;

import java.util.HashMap;

public class IssueRepository {

    HashMap<Integer,Issue> issueRepository = new HashMap<>();

    public void add(Issue issue){
        issueRepository.put(issue.id, issue);

    }


}
