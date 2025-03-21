package main.commands;

import main.core.Issue;
import main.features.IssueRepository;

public class IssueCreateCommand extends Command{
    private Issue issue;
    private IssueRepository issueRepository;

    public IssueCreateCommand(Issue _issue, IssueRepository _issueRepository) {
        super();
        this.issue = _issue;
        this.issueRepository = _issueRepository;
    }

    @Override
    public void execute() {
        Issue clonedIssue = issue.clone();
        issueRepository.AddIssueToRepository(clonedIssue);
    }

    @Override
    public void undo() {
        String issueId = issue.GetId();
        issueRepository.RemoveIssueFromRepository(issueId);
    }
}
