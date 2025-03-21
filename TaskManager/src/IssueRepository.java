import java.util.ArrayList;
import java.util.List;

public class IssueRepository {
    private Prototype prototype;
    private List<Issue> issueList;

    public IssueRepository(Prototype prototype){
        this.prototype = prototype;
        this.issueList = new ArrayList<>();
    }

    public Issue createIssue(){
        Issue issue = prototype.clone();
        issueList.add(issue);
        return issue;
    }
}
