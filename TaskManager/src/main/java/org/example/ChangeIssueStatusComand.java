package org.example;

public class ChangeIssueStatusComand implements Command{
    private Issue issue;

    public void ChangeIssueStatusCommand(Issue issue){
        this.issue= issue;
    }
    public void execute(){
        issue.changeIssueStatus();
    }
}
