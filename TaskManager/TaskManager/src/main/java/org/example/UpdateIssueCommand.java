package org.example;

import java.util.UUID;

class UpdateIssueCommand implements Command {
    private final IssueRepository repository;
    private final UUID issueId;
    private final Issue oldIssue;
    private final Issue newIssue;

    public UpdateIssueCommand(IssueRepository repository, UUID issueId, Issue newIssue) throws CloneNotSupportedException {
        this.repository = repository;
        this.issueId = issueId;
        this.oldIssue = repository.getIssue(issueId).clone();
        this.newIssue = newIssue;
    }

    public void execute() {
        repository.updateIssue(issueId, newIssue);
        System.out.println("Issue updated: " + issueId);
    }

    public void undo() {
        repository.updateIssue(issueId, oldIssue);
        System.out.println("Issue update undone: " + issueId);
    }
}
