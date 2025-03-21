package org.example;

import command.ChangeStatusCommand;
import command.CommandManager;
import command.CreateIssueCommand;
import model.Issue;
import model.Priority;
import model.Status;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import repository.IssueRepository;

import static org.junit.jupiter.api.Assertions.*;

public class UndoRedoStackTest {
    private IssueRepository repository;
    private CommandManager commandManager;
    private Issue testIssue;
    
    @BeforeEach
    public void setUp() {

        repository = IssueRepository.getInstance();

        for (String id : repository.getAllIssues().keySet()) {
            repository.removeIssue(id);
        }
        
        commandManager = CommandManager.getInstance();
        

        testIssue = new Issue("Test Issue", "This is a test issue", Priority.Medium);
        repository.addIssue(testIssue);
    }
    
    @Test
    public void UndoRedo_ShouldMaintainProperStacks() {

        CreateIssueCommand createCommand = new CreateIssueCommand(testIssue);
        commandManager.executeCommand(createCommand);
        

        ChangeStatusCommand statusCommand1 = new ChangeStatusCommand(testIssue, Status.InProgress);
        commandManager.executeCommand(statusCommand1);
        assertEquals(Status.InProgress, testIssue.getStatus());
        

        ChangeStatusCommand statusCommand2 = new ChangeStatusCommand(testIssue, Status.UnderReview);
        commandManager.executeCommand(statusCommand2);
        assertEquals(Status.UnderReview, testIssue.getStatus());
        

        commandManager.undoCommand();
        assertEquals(Status.InProgress, testIssue.getStatus(), "After first undo, status should be InProgress");
        
        commandManager.undoCommand();
        assertEquals(Status.Open, testIssue.getStatus(), "After second undo, status should be Open");

        commandManager.redoCommand();
        assertEquals(Status.InProgress, testIssue.getStatus(), "After redo, status should be InProgress");
        

        ChangeStatusCommand statusCommand3 = new ChangeStatusCommand(testIssue, Status.Resolved);
        commandManager.executeCommand(statusCommand3);
        assertEquals(Status.Resolved, testIssue.getStatus(), "After new command, status should be Resolved");
        

        commandManager.redoCommand();
        assertEquals(Status.Resolved, testIssue.getStatus(), "Status should still be Resolved after attempting redo");

        assertTrue(commandManager.canUndo(), "Should be able to undo after all operations");
        assertFalse(commandManager.canRedo(), "Should not be able to redo after new command execution");
    }
}