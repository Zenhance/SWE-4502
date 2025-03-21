package main.features;

import main.core.Issue;
import java.util.HashMap;

public class IssueRepository {
    HashMap<String, Issue> issueHashMap;

    public IssueRepository() {
        this.issueHashMap = new HashMap<String, Issue>();
    }

    public void AddIssueToRepository(Issue i) {
        String issueId = i.GetId();
        issueHashMap.put(issueId, i);
    }

    public Issue GetIssueFromRepository(String issueId) {
        issueHashMap.get(issueId);
    }

    public void RemoveIssueFromRepository(String issueId) {
        issueHashMap.remove(issueId);
    }

    public void EmptyIssuesFromRepository() {
        issueHashMap.clear();
    }

    public void ListAllIssuesInRepository() {
        for (String issueId : issueHashMap.values()) {
            System.out.println("Issue ->" + issueId);
        }
    }
}
