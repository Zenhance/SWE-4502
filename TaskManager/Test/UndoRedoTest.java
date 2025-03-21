package test;

import commands.ChangeStatusCommand;
import commands.CommandManager;
import models.Issue;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class UndoRedoTest {
    @Test
    public void UndoRedo_ShouldMaintainProperStacks() {
        Issue issue = new Issue(1, "Bug Fix", "Fix login issue", "High");
        CommandManager manager = new CommandManager();

        ChangeStatusCommand command1 = new ChangeStatusCommand(issue, "InProgress");
        ChangeStatusCommand command2 = new ChangeStatusCommand(issue, "UnderReview");

        manager.executeCommand(command1);
        manager.executeCommand(command2);

        // After executing the first two commands, the status should be "UnderReview"
        assertEquals("UnderReview", issue.getStatus());

        manager.undo(); // Undo the "UnderReview" change
        assertEquals("InProgress", issue.getStatus()); // The status should now be "InProgress"

        manager.undo(); // Undo the "InProgress" change
        assertEquals("Open", issue.getStatus()); // The status should go back to the initial state "Open"

        manager.redo(); // Redo the "InProgress" change
        assertEquals("InProgress", issue.getStatus());

        manager.redo(); // Redo the "UnderReview" change
        assertEquals("UnderReview", issue.getStatus());

        manager.executeCommand(new ChangeStatusCommand(issue, "Closed"));
        assertEquals("Closed", issue.getStatus()); // After executing a new command, the status should be "Closed"

        // Test that after a new command is executed, redo should not be available
        assertThrows(IllegalStateException.class, manager::redo); // Since no further redo is available, it should throw an exception
    }
}