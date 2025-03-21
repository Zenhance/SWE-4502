package main.commands;

import main.core.Issue;
import main.features.IssueRepository;

public class IssueCreateCommand extends Command{
    private Issue issue;
    private String title;
    private String description;
    private String assignedTo;
    private IssueRepository issueRepository;

    public IssueCreateCommand(String _title, String _description, String _assignedTo) {
        super();
        this.title = _title;
        this.description = _description;
        this.assignedTo = _assignedTo;
        this.issueRepository = new IssueRepository();
    }

    @Override
    public void execute() {
        issue = new Issue(title, description, assignedTo);
        issueRepository.AddIssueToRepository(issue);
    }

    @Override
    public void undo() {
        String issueId = issue.GetId();
        issueRepository.RemoveIssueFromRepository(issueId);
    }
}
