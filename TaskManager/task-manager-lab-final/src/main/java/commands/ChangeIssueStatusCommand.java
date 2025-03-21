package commands;

import db.IssueReposity;
import models.CommandType;
import models.Issue;
import models.Status;
import java.time.LocalDateTime;

public class ChangeIssueStatusCommand extends Command {
    private IssueReposity repository;
    private String issueId;
    private Status newStatus;
    private Status oldStatus;

    public ChangeIssueStatusCommand(IssueReposity repository, String issueId, Status newStatus) {
        super("Change status of issue " + issueId + " to " + newStatus, CommandType.UPDATE);
        this.repository = repository;
        this.issueId = issueId;
        this.newStatus = newStatus;
    }

    @Override
    public void execute() {
        Issue issue = repository.getIssue(issueId);
        if (issue != null) {
            oldStatus = issue.getStatus();
            issue.setStatus(newStatus);
            issue.setLastModifiedDate(LocalDateTime.now());
            repository.updateIssue(issue);
        }
    }

    @Override
    public void undo() {
        Issue issue = repository.getIssue(issueId);
        if (issue != null && oldStatus != null) {
            issue.setStatus(oldStatus);
            issue.setLastModifiedDate(LocalDateTime.now());
            repository.updateIssue(issue);
        }
    }
}