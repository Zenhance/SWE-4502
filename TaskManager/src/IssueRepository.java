import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class IssueRepository {
    private Prototype prototype;
    private HashMap<String, Issue> issueHashMap;

    public IssueRepository(Prototype prototype){
        this.prototype = prototype;
        this.issueHashMap = new HashMap<>();
    }

    public Issue createIssue(){
        Issue issue = prototype.clone();
        issueHashMap.put(issue.getId(), issue);
        return issue;
    }

    public Prototype getPrototype() {
        return prototype;
    }

    public void setPrototype(Prototype prototype) {
        this.prototype = prototype;
    }

    public HashMap<String, Issue> getIssueHashMap() {
        return issueHashMap;
    }

    public void setIssueHashMap(HashMap<String, Issue> issueHashMap) {
        this.issueHashMap = issueHashMap;
    }
}
