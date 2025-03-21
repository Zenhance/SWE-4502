package com.taskmanager.command;

import com.taskmanager.model.Issue;
import com.taskmanager.service.IssueService;
public class CreateIssueCommand implements Command {
    private IssueService issueService;
    private Issue issue;

    public CreateIssueCommand(IssueService issueService, Issue issue) {
        this.issueService = issueService;
        this.issue = issue;
    }

    @Override
    public void execute() {
        issueService.createIssue(issue);
    }

    @Override
    public void undo() {
    }
}




//
//    public CreateIssueCommand(IssueService issueService, Issue issue) {
//        this.issueService = issueService;
//        this.issue = issue;
//    }
//
//    @Override
//    public void execute() {
//        issueService.createIssue(issue);
//    }
//
//    @Override
//    public void undo() {
//        // Implement undo logic
//    }
//}
