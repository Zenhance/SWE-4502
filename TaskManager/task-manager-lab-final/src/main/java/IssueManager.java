import commands.*;
import db.IssueReposity;
import models.Issue;
import models.Priority;
import models.Status;
import subjects.CommandManager;

import java.time.LocalDateTime;
import java.util.UUID;

public class IssueManager {
    private IssueReposity repository;
    private CommandManager commandManager;

    public IssueManager(IssueReposity repository, CommandManager commandManager) {
        this.repository = repository;
        this.commandManager = commandManager;
    }

    public void createIssue(String title, String description, Priority priority) {
        Issue issue = new Issue();
        issue.setId(UUID.randomUUID().toString());
        issue.setTitle(title);
        issue.setDescription(description);
        issue.setPriority(priority);
        issue.setStatus(Status.OPEN);
        issue.setCreationDate(LocalDateTime.now());
        issue.setLastModifiedDate(LocalDateTime.now());

        Command command = new CreateIssueCommand(repository, issue);
        commandManager.executeCommand(command);
    }

    public void updateIssue(String id, String title, String description, Priority priority, String newAssignedTo) {
        Issue issue = repository.getIssue(id);
        if (issue != null) {
            Command command = new UpdateIssueCommand(repository, id, title, description, priority, newAssignedTo);
            commandManager.executeCommand(command);
        }
    }

    public void changeStatus(String id, Status newStatus) {
        Issue issue = repository.getIssue(id);
        if (issue != null) {
            Command command = new ChangeIssueStatusCommand(repository, id, newStatus);
            commandManager.executeCommand(command);
        }
    }

    public void addComment(String issueId, String content, String author) {
        Issue issue = repository.getIssue(issueId);
        if (issue != null) {
            Command command = new AddCommentCommand(repository, issueId, content, author);
            commandManager.executeCommand(command);
        }
    }

    public void undo() {
        commandManager.undo();
    }

    public void redo() {
        commandManager.redo();
    }
}