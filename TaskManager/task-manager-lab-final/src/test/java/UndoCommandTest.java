import commands.ChangeIssueStatusCommand;
import commands.CreateIssueCommand;
import db.IssueReposity;
import models.Issue;
import models.Priority;
import models.Status;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import subjects.CommandManager;

import static org.junit.jupiter.api.Assertions.*;

public class UndoCommandTest {
    private IssueReposity repository;
    private CommandManager commandManager;
    private Issue testIssue;

    @BeforeEach
    public void setUp() {
        repository = new IssueReposity();
        commandManager = new CommandManager();

        testIssue = new Issue();
        testIssue.setId("1");
        testIssue.setTitle("Test Issue");
        testIssue.setDescription("Test Description");
        testIssue.setPriority(Priority.MEDIUM);
        testIssue.setStatus(Status.OPEN);

        CreateIssueCommand createCommand = new CreateIssueCommand(repository, testIssue);
        commandManager.executeCommand(createCommand);
    }

    @Test
    public void UndoCommand_ShouldRevertLastAction() {
        Status newStatus = Status.IN_PROGRESS;
        ChangeIssueStatusCommand command = new ChangeIssueStatusCommand(repository, "1", newStatus);
        commandManager.executeCommand(command);

        commandManager.undo();

        Issue retrievedIssue = repository.getIssue("1");
        assertNotNull(retrievedIssue, "Issue should exist");
        assertEquals(Status.OPEN, retrievedIssue.getStatus(), "Issue status should be reverted to OPEN");
    }
}