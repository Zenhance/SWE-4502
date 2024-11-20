package commands;

import models.Issue;
import models.IssueRepository;

public class CreateIssueCommand extends Command {
    private IssueRepository repository;
    private Issue issue;

    public CreateIssueCommand(IssueRepository repository, Issue issue) {
        super("Created issue: " + issue.getTitle(), "Create");
        this.repository = repository;
        this.issue = issue;
    }

    @Override
    public void execute() {
        repository.addIssue(issue);
    }

    @Override
    public void undo() {
        repository.removeIssue(issue.getId());
}
}