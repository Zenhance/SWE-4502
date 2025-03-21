package org.example;

import command.CommandLog;
import command.CommandManager;
import command.ChangeStatusCommand;
import model.Issue;
import model.Priority;
import model.Status;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import repository.IssueRepository;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class StatusChangeLoggingTest {
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
    public void ChangeIssueStatusCommand_ShouldLogCorrectDescription() {

        int initialLogCount = commandManager.getCommandLogs().size();
        

        Status newStatus = Status.InProgress;
        ChangeStatusCommand command = new ChangeStatusCommand(testIssue, newStatus);
        commandManager.executeCommand(command);
        

        List<CommandLog> logs = commandManager.getCommandLogs();
        String lastLogString = logs.get(logs.size() - 1).toString();
        

        assertTrue(lastLogString.contains("status") || lastLogString.contains("Status"), 
                "Log should contain information about status change");
        assertTrue(lastLogString.contains("InProgress"), 
                "Log should contain the new status value");
    }
}