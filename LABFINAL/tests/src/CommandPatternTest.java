
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


class CommandPatternTest {
    private Issue issue;
    private CommandManager issueManager;

    @BeforeEach
    void setUp() {
        issue = new Issue(1, "Sample Issue", "This is a test issue", Priority.MEDIUM, Status.Open,"Alice");
        issueManager = new CommandManager();
    }

    @Test
    void ChangeStatus_ShouldUpdateIssueStatus() {
        Command changeStatusCommand = new ChangeStatusCommand(issue, Status.RESOLVED);
        issueManager.executeCommand(changeStatusCommand);

        assertEquals(Status.RESOLVED, issue.getStatus(), "Issue status should be updated to RESOLVED");
    }

     @Test
   void UndoCommand_ShouldRevertLastAction() {
        Command changeStatusCommand = new ChangeStatusCommand(issue, Status.IN_PROGRESS);
        issueManager.executeCommand(changeStatusCommand);
        issueManager.undo();

        assertEquals(Status.Open, issue.getStatus(), "Undo should revert status to OPEN");
    }

    @Test
    void RedoCommand_ShouldReapplyUndoneAction() {
        Command changeStatusCommand = new ChangeStatusCommand(issue, Status.UNDER_REVIEW);
        issueManager.executeCommand(changeStatusCommand);
        issueManager.undo();
        issueManager.redo();
        //done
        assertEquals(Status.UNDER_REVIEW, issue.getStatus(), "Redo should reapply status change to UNDER_REVIEW");
    }
}
