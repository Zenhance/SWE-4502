package Class;

import java.util.ArrayList;
import java.util.List;
import Predefinedvalues.*;

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

    public void updateStatus(Issue issue, Status status){
      issue.setStatus(status);
    }

    public List<Issue> GetAllIssues() {
        return new ArrayList<>(issues);
    }
}