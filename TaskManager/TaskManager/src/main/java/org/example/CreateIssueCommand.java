package org.example;

class CreateIssueCommand implements Command {
    private final IssueRepository repository;
    private final Issue issue;

    public CreateIssueCommand(IssueRepository repository, Issue issue) {
        this.repository = repository;
        this.issue = issue;
    }

    public void execute() {
        repository.addIssue(issue);
        System.out.println("Issue created: " + issue.getId());
    }

    public void undo() {
        repository.updateIssue(issue.getId(), null);
        System.out.println("Issue creation undone: " + issue.getId());
    }
}
