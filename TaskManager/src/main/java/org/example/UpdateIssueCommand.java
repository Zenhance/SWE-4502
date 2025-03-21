package org.example;

public class UpdateIssueCommand implements Command{
//    private Issue issue;
//    public CreateIssueCommand(Issue issue){
//        this.issue= issue;
//    }
//    public void execute(){
//        issue.createIssue();
//    }

    private Issue issue;
    public UpdateIssueCommand(Issue issue){
        this.issue= issue;
    }
    public void execute(){
        issue.updateIssue();
    }
}
