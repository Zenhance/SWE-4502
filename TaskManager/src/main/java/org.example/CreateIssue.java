package org.example;

public class CreateIssue implements Command {
    private IssueRepository repository;
    private Issue issue;

    public CreateIssue(IssueRepository repository, Issue issue) {
        this.repository = repository;
        this.issue = issue;
    }

    @Override
    public void execute() {
        repository.addIssue(issue);
    }

    @Override
    public void undo() {
        repository.deleteIssue(issue.getId());
    }
}