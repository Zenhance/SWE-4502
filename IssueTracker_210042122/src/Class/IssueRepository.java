package Class;

import java.util.ArrayList;
import java.util.List;

public class IssueRepository {
    public List<Issue> issues = new ArrayList<Issue>();

public IssueRepository (List<Issue>issues){
    this.issues=issues;
}

    public void CreateIssue(Issue issue) {
            issues.add(issue);
            System.out.println("Success");

    }

    public void updateComment(Issue issue, Comment c){
       issue.addComment(c);
    }

    public List<Issue> GetAllIssues() {
        return new ArrayList<>(issues);
    }
}