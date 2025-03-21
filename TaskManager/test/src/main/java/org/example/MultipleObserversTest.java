package org.example;

import command.Command;
import command.CommandManager;
import command.CommandObserver;
import command.CreateIssueCommand;
import model.Issue;
import model.Priority;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import repository.IssueRepository;

import static org.junit.jupiter.api.Assertions.*;

public class MultipleObserversTest {
    private IssueRepository repository;
    private CommandManager commandManager;
    private TestObserver observer1;
    private TestObserver observer2;
    
    // test observer
    private static class TestObserver implements CommandObserver {
        private int notificationCount = 0;
        
        @Override
        public void update(Command command) {
            notificationCount++;
        }
        
        public int getNotificationCount() {
            return notificationCount;
        }
        
        public void resetCount() {
            notificationCount = 0;
        }
    }
    
    @BeforeEach
    public void setUp() {
        repository = IssueRepository.getInstance();

        for (String id : repository.getAllIssues().keySet()) {
            repository.removeIssue(id);
        }
        
        commandManager = CommandManager.getInstance();

        observer1 = new TestObserver();
        observer2 = new TestObserver();
        commandManager.addObserver(observer1);
        commandManager.addObserver(observer2);
    }
    
    @Test
    public void MultipleObservers_ShouldAllBeNotified() {
        observer1.resetCount();
        observer2.resetCount();
        

        Issue issue = new Issue("Test Issue", "This is a test issue", Priority.Medium);
        CreateIssueCommand command = new CreateIssueCommand(issue);
        commandManager.executeCommand(command);

        assertEquals(1, observer1.getNotificationCount(), "Observer 1 should be notified exactly once");
        assertEquals(1, observer2.getNotificationCount(), "Observer 2 should be notified exactly once");
    }
}