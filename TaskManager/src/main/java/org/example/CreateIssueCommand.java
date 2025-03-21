package org.example;

public class CreateIssueCommand implements Command{
    private Issue issue;
    public CreateIssueCommand(Issue issue){
        this.issue= issue;
    }
    public void execute(){
        issue.createIssue();
    }
}
