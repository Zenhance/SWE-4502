package commands;

import db.IssueReposity;
import models.CommandType;
import models.Issue;
import models.Priority;
import java.time.LocalDateTime;

public class UpdateIssueCommand extends Command {
    private IssueReposity repository;
    private String issueId;
    private String newTitle;
    private String newDescription;
    private Priority newPriority;
    private String newAssignedTo;

    // Store old values for undo
    private Issue originalIssue;

    public UpdateIssueCommand(IssueReposity repository, String issueId,
                              String title, String description, Priority priority, String newAssignedTo) {
        super("Update issue: " + issueId, CommandType.UPDATE);
        this.repository = repository;
        this.issueId = issueId;
        this.newTitle = title;
        this.newDescription = description;
        this.newPriority = priority;
        this.newAssignedTo = newAssignedTo;
    }

    @Override
    public void execute() {
        Issue issue = repository.getIssue(issueId);
        if (issue != null) {
            if (newTitle != null) issue.setTitle(newTitle);
            if (newDescription != null) issue.setDescription(newDescription);
            if (newPriority != null) issue.setPriority(newPriority);
            if (newAssignedTo != null) issue.setAssignedTo(newAssignedTo);
            issue.setLastModifiedDate(LocalDateTime.now());
            repository.updateIssue(issue);
        }
    }

    @Override
    public void undo() {
        if (originalIssue != null) {
            repository.updateIssue(originalIssue);
        }
    }
}