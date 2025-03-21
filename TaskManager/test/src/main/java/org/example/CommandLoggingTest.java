package org.example;

import command.CommandLog;
import command.CommandManager;
import command.CreateIssueCommand;
import command.AddCommentCommand;
import model.Comment;
import model.Issue;
import model.Priority;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import repository.IssueRepository;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class CommandLoggingTest {
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
    public void Logger_ShouldStoreCommandHistoryLogs() {

        int initialLogCount = commandManager.getCommandLogs().size();
        

        Issue issue = new Issue("Test Issue", "This is a test issue", Priority.Medium);
        CreateIssueCommand createCommand = new CreateIssueCommand(issue);
        commandManager.executeCommand(createCommand);
        
        Comment comment = new Comment("Test comment", "Test User");
        AddCommentCommand addCommentCommand = new AddCommentCommand(issue, comment);
        commandManager.executeCommand(addCommentCommand);
        
        // Assert
        List<CommandLog> logs = commandManager.getCommandLogs();
        assertEquals(initialLogCount + 2, logs.size(), "Log count should be incremented by 2");
        String lastLogString = logs.get(logs.size() - 1).toString();
        String secondLastLogString = logs.get(logs.size() - 2).toString();
        
        // Verify
        assertTrue(lastLogString.contains("comment") || lastLogString.contains("Comment"), 
                "Last log should contain information about adding a comment");
        assertTrue(secondLastLogString.contains("issue") || secondLastLogString.contains("Issue"), 
                "Second last log should contain information about creating an issue");
    }
}