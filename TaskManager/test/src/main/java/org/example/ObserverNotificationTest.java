package org.example;

import command.Command;
import command.CommandManager;
import command.CommandObserver;
import command.CreateIssueCommand;
import model.Issue;
import model.Priority;
import notification.NotificationService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import repository.IssueRepository;

import static org.junit.jupiter.api.Assertions.*;

public class ObserverNotificationTest {
    private IssueRepository repository;
    private CommandManager commandManager;
    private NotificationService notificationService;
    
    @BeforeEach
    public void setUp() {
        repository = IssueRepository.getInstance();

        for (String id : repository.getAllIssues().keySet()) {
            repository.removeIssue(id);
        }
        
        commandManager = CommandManager.getInstance();
        notificationService = NotificationService.getInstance();

        commandManager.addObserver(notificationService);
    }
    
    @Test
    public void Observer_ShouldBeNotifiedOfCommands() {
        int initialCount = notificationService.getNotificationCount();

        Issue issue = new Issue("Test Issue", "This is a test issue", Priority.Medium);
        CreateIssueCommand command = new CreateIssueCommand(issue);
        commandManager.executeCommand(command);

        assertEquals(initialCount + 1, notificationService.getNotificationCount());
    }
}