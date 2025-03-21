package models;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class IssueRepository {
    private HashMap<String, Issue> issues = new HashMap<>();
    public void addIssue(Issue issue){
        issues.put(issue.getId(), issue);
    }
    public void removeIssue(String id){
        issues.remove(id);
    }

    public Issue getIssue(String id){

        return issues.get(id);
    }
    public HashMap<String, Issue> getAllIssue(){
        return  issues;
    }
}
