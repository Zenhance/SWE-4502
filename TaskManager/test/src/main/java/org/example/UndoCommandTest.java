package org.example;

import command.CommandManager;
import command.CreateIssueCommand;
import model.Issue;
import model.Priority;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import repository.IssueRepository;

import static org.junit.jupiter.api.Assertions.*;

public class UndoCommandTest {
    private IssueRepository repository;
    private CommandManager commandManager;
    
    @BeforeEach
    public void setUp() {
        // Reset
        repository = IssueRepository.getInstance();
        // Clear
        for (String id : repository.getAllIssues().keySet()) {
            repository.removeIssue(id);
        }
        
        commandManager = CommandManager.getInstance();
    }
    
    @Test
    public void UndoCommand_ShouldRevertLastAction() {

        Issue issue = new Issue("Test Issue", "This is a test issue", Priority.Medium);
        CreateIssueCommand command = new CreateIssueCommand(issue);
        

        commandManager.executeCommand(command);
        assertTrue(repository.containsIssue(issue.getId()));
        
        commandManager.undoCommand();

        assertFalse(repository.containsIssue(issue.getId()));
    }
}