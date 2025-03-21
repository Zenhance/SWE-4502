package org.example;

import command.CommandManager;
import command.CreateIssueCommand;
import model.Issue;
import model.Priority;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import repository.IssueRepository;

import static org.junit.jupiter.api.Assertions.*;

public class RedoCommandTest {
    private IssueRepository repository;
    private CommandManager commandManager;
    
    @BeforeEach
    public void setUp() {

        repository = IssueRepository.getInstance();

        for (String id : repository.getAllIssues().keySet()) {
            repository.removeIssue(id);
        }
        
        commandManager = CommandManager.getInstance();
    }
    
    @Test
    public void RedoCommand_ShouldReapplyUndoneAction() {

        Issue issue = new Issue("Test Issue", "This is a test issue", Priority.Medium);
        CreateIssueCommand command = new CreateIssueCommand(issue);

        commandManager.executeCommand(command);
        assertTrue(repository.containsIssue(issue.getId()));
        
        commandManager.undoCommand();
        assertFalse(repository.containsIssue(issue.getId()));
        
        commandManager.redoCommand();
        

        assertTrue(repository.containsIssue(issue.getId()));
        Issue retrievedIssue = repository.getIssue(issue.getId());
        assertEquals("Test Issue", retrievedIssue.getTitle());
        assertEquals("This is a test issue", retrievedIssue.getDescription());
        assertEquals(Priority.Medium, retrievedIssue.getPriority());
    }
}