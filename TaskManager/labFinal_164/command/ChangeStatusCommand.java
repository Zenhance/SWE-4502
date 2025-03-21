package labFinal_164.command;

import labFinal_164.model.Issue;
import labFinal_164.model.Status;
import labFinal_164.repository.IssueRepository;

public class ChangeStatusCommand implements ICommand {
    private IssueRepository repository;
    private String issueId;
    private Status oldStatus;
    private Status newStatus;
    private String description;

    public ChangeStatusCommand(IssueRepository repository, String issueId, Status newStatus) {
        this.repository = repository;
        this.issueId = issueId;
        this.newStatus = newStatus;
        this.oldStatus = repository.getIssue(issueId).getStatus();
        this.description = "Change status of " + issueId + " from " + oldStatus + " to " + newStatus;
    }
    @Override
    public void execute() {
        Issue issue = repository.getIssue(issueId);
        issue.setStatus(newStatus);
        repository.updateIssue(issue);
    }

    @Override
    public void undo() {
        Issue issue = repository.getIssue(issueId);
        issue.setStatus(oldStatus);
        repository.updateIssue(issue);
    }

    @Override
    public String getType() { return "UPDATE"; }
    @Override
    public String getDescription() { return description; }



}
