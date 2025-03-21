package commands;

import enums.Status;
import interfaces.Command;
import models.Issue;
import models.IssueRepository;

public class ChangeIssueStatusCommand extends Command {
    private final IssueRepository issueRepo;
    private final Issue issue;
    private final Status newStatus;
    private Status oldStatus;

    public ChangeIssueStatusCommand(IssueRepository repository, String issueId, Status newStatus, String desc, String type) {
        super(desc, type);

        this.issueRepo = repository;
        this.issue = issueRepo.getIssue(issueId);
        this.newStatus = newStatus;
    }

    @Override
    public void execute() {
        oldStatus = issue.getStatus();
        issue.setStatus(newStatus);
    }

    @Override
    public void undo() {
        if (oldStatus != null) {
            issue.setStatus(oldStatus);
        }
    }

}