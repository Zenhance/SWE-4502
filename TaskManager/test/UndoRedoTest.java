package test;

import commands.ChangeStatusCommand;
import commands.CommandManager;
import models.Issue;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class UndoRedoTest {
    @Test
    public void UndoCommand_ShouldRevertLastAction() {
        Issue issue = new Issue(1, "Bug Fix", "Fix login issue", "High");
        ChangeStatusCommand command = new ChangeStatusCommand(issue, "Resolved");
        CommandManager manager = new CommandManager();

        manager.executeCommand(command);
        assertEquals("Resolved", issue.getStatus());

        manager.undo();
        assertEquals("Open", issue.getStatus());
    }


}