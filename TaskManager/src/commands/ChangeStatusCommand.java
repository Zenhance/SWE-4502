package commands;

import models.Issue;

public class ChangeStatusCommand extends Command {
    private Issue issue;
    private String previousStatus;
    private String newStatus;

    public ChangeStatusCommand(Issue issue, String newStatus) {
        super("Changed status to: " + newStatus, "Update");
        this.issue = issue;
        this.previousStatus = issue.getStatus();
        this.newStatus = newStatus;
    }

    @Override
    public void execute() {
        issue.setStatus(newStatus);
    }

    @Override
    public void undo() {
        issue.setStatus(previousStatus);
    }
}