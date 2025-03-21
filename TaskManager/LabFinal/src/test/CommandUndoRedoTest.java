package test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import taskmanager.TaskManager;
import model.Issue;
import model.Priority;
import model.Status;
import static org.junit.jupiter.api.Assertions.*;

public class CommandUndoRedoTest {
    private TaskManager taskManager;
    @BeforeEach
    void setUp()
    {
        taskManager = new TaskManager();
    }

    //#F04:
    @Test
    void undoCommand_ShouldRevertLastAction() {

        String issueId = taskManager.createIssue("Undo Command Testing", "Pleaseeeeeeee NO!", Priority.High);

        taskManager.changeStatus(issueId, Status.InProgress);
        Issue afterCommand = taskManager.getIssue(issueId);
        boolean undoResult = taskManager.undo();

        assertTrue(undoResult);
        Issue afterUndo = taskManager.getIssue(issueId);
        assertEquals(Status.InProgress, afterCommand.getStatus());
        assertEquals(Status.Open, afterUndo.getStatus());
    }

    //#F05
    @Test
    void redoCommand_ShouldReapplyUndoneAction()
    {
        String issueId = taskManager.createIssue("Redo Command Testing", "Dump!!!!", Priority.Medium);

        taskManager.changeStatus(issueId, Status.InProgress);
        taskManager.undo();
        boolean redoResult = taskManager.redo();

        assertTrue(redoResult);
        Issue afterRedo = taskManager.getIssue(issueId);
        assertEquals(Status.InProgress, afterRedo.getStatus());
    }

}