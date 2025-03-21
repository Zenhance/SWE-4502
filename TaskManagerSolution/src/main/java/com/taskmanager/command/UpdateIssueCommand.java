package com.taskmanager.command;

import com.taskmanager.model.Issue;
import com.taskmanager.service.IssueService;

public class UpdateIssueCommand implements Command {
    private IssueService issueService;
    private Issue issue;

    public UpdateIssueCommand(IssueService issueService, Issue issue) {
        this.issueService = issueService;
        this.issue = issue;
    }

    @Override
    public void execute() {
        issueService.updateIssue(issue);
    }

    @Override
    public void undo() {

    }
}

































