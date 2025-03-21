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

import java.lang.reflect.Field;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ObserverRemovalTest {
    private IssueRepository repository;
    private CommandManager commandManager;
    private TestObserver testObserver;

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
    public void setUp() throws Exception {
        repository = IssueRepository.getInstance();

        for (String id : repository.getAllIssues().keySet()) {
            repository.removeIssue(id);
        }
        
        commandManager = CommandManager.getInstance();
        

        testObserver = new TestObserver();
        

        commandManager.addObserver(testObserver);

        Field observersField = CommandManager.class.getDeclaredField("observers");
        observersField.setAccessible(true);
        List<CommandObserver> observers = (List<CommandObserver>) observersField.get(commandManager);
        observers.remove(testObserver);
        

        commandManager.addObserver(testObserver);
    }
    
    @Test
    public void RemoveObserver_ShouldStopNotifications() throws Exception {

        testObserver.resetCount();

        Issue issue1 = new Issue("Test Issue 1", "This is test issue 1", Priority.Medium);
        CreateIssueCommand command1 = new CreateIssueCommand(issue1);
        commandManager.executeCommand(command1);

        assertEquals(1, testObserver.getNotificationCount(), "Observer should be notified before removal");

        Field observersField = CommandManager.class.getDeclaredField("observers");
        observersField.setAccessible(true);
        List<CommandObserver> observers = (List<CommandObserver>) observersField.get(commandManager);
        observers.remove(testObserver);
        

        testObserver.resetCount();
        

        Issue issue2 = new Issue("Test Issue 2", "This is test issue 2", Priority.Medium);
        CreateIssueCommand command2 = new CreateIssueCommand(issue2);
        commandManager.executeCommand(command2);

        assertEquals(0, testObserver.getNotificationCount(), "Observer should not be notified after removal");
    }
}