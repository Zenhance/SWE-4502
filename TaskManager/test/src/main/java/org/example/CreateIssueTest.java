package org.example;

import command.CommandManager;
import command.CommandType;
import command.CreateIssueCommand;
import model.Issue;
import model.Priority;
import model.Status;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import repository.IssueRepository;

import static org.junit.jupiter.api.Assertions.*;

public class CreateIssueTest {
    private IssueRepository repository;
    private CommandManager commandManager;
    
    @BeforeEach
    public void setUp() {
        // reset
        repository = IssueRepository.getInstance();
        // clear
        for (String id : repository.getAllIssues().keySet()) {
            repository.removeIssue(id);
        }
        
        commandManager = CommandManager.getInstance();
    }
    
    @Test
    public void CreateIssue_ShouldAddIssueToRepository() {
        // Aadd issue
        Issue issue = new Issue("Test Issue", "This is a test issue", Priority.Medium);
        CreateIssueCommand command = new CreateIssueCommand(issue);
        commandManager.executeCommand(command);
        
        // verify
        assertTrue(repository.containsIssue(issue.getId()));
        Issue retrievedIssue = repository.getIssue(issue.getId());
        assertEquals("Test Issue", retrievedIssue.getTitle());
        assertEquals("This is a test issue", retrievedIssue.getDescription());
        assertEquals(Priority.Medium, retrievedIssue.getPriority());
        assertEquals(Status.Open, retrievedIssue.getStatus()); // Default status
    }
}