package org.example;

import command.ChangeStatusCommand;
import command.CommandManager;
import model.Issue;
import model.Priority;
import model.Status;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import repository.IssueRepository;

import static org.junit.jupiter.api.Assertions.*;

public class ChangeStatusTest {
    private IssueRepository repository;
    private CommandManager commandManager;

    private Issue testIssue;
    
    @BeforeEach
    public void setUp() {
        // reset repoo
        repository = IssueRepository.getInstance();
        // clear
        for (String id : repository.getAllIssues().keySet()) {

            repository.removeIssue(id);
        }
        
        commandManager = CommandManager.getInstance();
        
        // create issue
        testIssue = new Issue("Test Issue", "This is a test issue", Priority.Medium);
        repository.addIssue(testIssue);
    }
    
    @Test
    public void ChangeStatus_ShouldUpdateIssueStatus() {
        // change status
        Status newStatus = Status.InProgress;
        ChangeStatusCommand command = new ChangeStatusCommand(testIssue, newStatus);
        commandManager.executeCommand(command);
        
        // verify new status
        Issue retrievedIssue = repository.getIssue(testIssue.getId());
        assertEquals(Status.InProgress, retrievedIssue.getStatus());
    }
}