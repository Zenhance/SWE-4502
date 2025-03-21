package labFinal_164.command;

import labFinal_164.model.Status;
import labFinal_164.repository.IssueRepository;

public class ChangeStatusCommand {
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


}
