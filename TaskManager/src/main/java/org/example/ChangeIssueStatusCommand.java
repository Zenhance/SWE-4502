package org.example;

public class ChangeIssueStatusCommand implements Command{
    private Issue issue;

    public void ChangeIssueStatusCommand(Issue issue){
        this.issue= issue;
    }
    public void execute(){
        issue.changeIssueStatus();
    }
}
