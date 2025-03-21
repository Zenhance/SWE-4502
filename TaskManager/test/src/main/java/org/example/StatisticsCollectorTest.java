package org.example;

import command.CommandManager;
import command.CommandType;
import command.CreateIssueCommand;
import command.AddCommentCommand;
import command.ChangeStatusCommand;
import model.Comment;
import model.Issue;
import model.Priority;
import model.Status;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import repository.IssueRepository;

import static org.junit.jupiter.api.Assertions.*;

public class StatisticsCollectorTest {
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
    public void StatisticsCollector_ShouldTrackCommandCounts() {

        int initialCreateCount = commandManager.getStatistics().getCommandCount(CommandType.Create);
        int initialUpdateCount = commandManager.getStatistics().getCommandCount(CommandType.Update);
        

        Issue issue = new Issue("Test Issue", "This is a test issue", Priority.Medium);
        CreateIssueCommand createCommand = new CreateIssueCommand(issue);
        commandManager.executeCommand(createCommand);
        

        Comment comment = new Comment("Test comment", "Test User");
        AddCommentCommand addCommentCommand = new AddCommentCommand(issue, comment);
        commandManager.executeCommand(addCommentCommand);
        

        ChangeStatusCommand changeStatusCommand = new ChangeStatusCommand(issue, Status.InProgress);
        commandManager.executeCommand(changeStatusCommand);
        

        assertEquals(initialCreateCount + 1, commandManager.getStatistics().getCommandCount(CommandType.Create), 
                "Create command count should be incremented by 1");
        assertEquals(initialUpdateCount + 2, commandManager.getStatistics().getCommandCount(CommandType.Update), 
                "Update command count should be incremented by 2");
    }
}