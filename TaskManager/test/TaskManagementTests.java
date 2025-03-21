import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;

import java.util.ArrayList;
import java.util.List;

public class TaskManagementTests {
    private IssueRepository repository;
    private CommandInvoker invoker;
    private NotificationService notificationService;

    @BeforeEach
    public void setup() {
        repository = new IssueRepository();
        invoker = new CommandInvoker();
        notificationService = new NotificationService();
    }

    @Test
    public void CreateIssue_ShouldAddIssueToRepository() {
        Issue issue = new Issue("1", "Test Issue", "Description", Priority.MEDIUM, "Alice");
        CreateIssueCommand createCommand = new CreateIssueCommand(repository, issue);
        invoker.executeCommand(createCommand);
        Issue retrieved = repository.getIssue("1");
        assertNotNull(retrieved);
        assertEquals("Test Issue", retrieved.getTitle());
        assertEquals(Status.OPEN, retrieved.getStatus());
    }

    @Test
    public void AddComment_ShouldAddCommentToIssue()
    {
        Issue issue = new Issue("2", "Issue for Comment", "Description", Priority.HIGH, "Bob");
        repository.addIssue(issue);
        Comment comment = new Comment("c1", "This is a comment", "Bob");
        AddCommentCommand addCommentCommand = new AddCommentCommand(repository, issue, comment);
        invoker.executeCommand(addCommentCommand);
        assertFalse(issue.getComments().isEmpty());
        assertEquals("This is a comment", issue.getComments().get(0).getContent());
    }

    @Test
    public void ChangeStatus_ShouldUpdateIssueStatus()
    {
        Issue issue = new Issue("3", "Issue Status", "Description", Priority.LOW, "Carol");
        repository.addIssue(issue);
        ChangeStatusCommand changeStatusCommand = new ChangeStatusCommand(repository, issue, Status.IN_PROGRESS);
        invoker.executeCommand(changeStatusCommand);
        assertEquals(Status.IN_PROGRESS, issue.getStatus());
    }

    @Test
    public void UndoCommand_ShouldRevertLastAction()
    {
        Issue issue = new Issue("4", "Undo Issue", "Description", Priority.HIGH, "Misaki");
        CreateIssueCommand createCommand = new CreateIssueCommand(repository, issue);
        invoker.executeCommand(createCommand);
        assertNotNull(repository.getIssue("4"));
        invoker.undo();
        assertNull(repository.getIssue("4"));

    }

    @Test
    public void RedoCommand_ShouldReapplyUndoneAction()
    {
        Issue issue = new Issue("5", "Redo Issue", "Description", Priority.MEDIUM, "Eva");
        CreateIssueCommand createCommand = new CreateIssueCommand(repository, issue);
        invoker.executeCommand(createCommand);
        invoker.undo();
        assertNull(repository.getIssue("5"));
        invoker.redo();
        assertNotNull(repository.getIssue("5"));
    }

    @Test
    public void Observer_ShouldBeNotifiedOfCommands() {
        List<String> messages = new ArrayList<>();
        Observer testObserver = message -> messages.add(message);
        notificationService.registerObserver(testObserver);
        notificationService.notifyObservers("Test notification");
        assertEquals(1, messages.size());
        assertEquals("Test notification", messages.get(0));
    }

    @Test
    public void StatisticsCollector_ShouldTrackCommandCounts() {
        DummyStatisticsCollector stats = new DummyStatisticsCollector();
        Issue issue1 = new Issue("6", "Stats Issue 1", "Desc", Priority.LOW, "Frank");
        Issue issue2 = new Issue("7", "Stats Issue 2", "Desc", Priority.HIGH, "Grace");
        CreateIssueCommand create1 = new CreateIssueCommand(repository, issue1);
        CreateIssueCommand create2 = new CreateIssueCommand(repository, issue2);
        ChangeStatusCommand changeStatus = new ChangeStatusCommand(repository, issue1,
                Status.RESOLVED);
        invoker.executeCommand(create1);
        stats.record("Create");
        invoker.executeCommand(create2);
        stats.record("Create");
        invoker.executeCommand(changeStatus);
        stats.record("ChangeStatus");
        assertEquals(2, stats.getCount("Create"));
        assertEquals(1, stats.getCount("ChangeStatus"));
    }

    @Test
    public void Logger_ShouldStoreCommandHistoryLogs() {
        CommandLogger logger = new CommandLogger();
        notificationService.registerObserver(logger);
        notificationService.notifyObservers("Logger test");
        List<String> logs = logger.getLogHistory();
        assertFalse(logs.isEmpty());
        assertEquals("Logger test", logs.get(0));
    }

    @Test
    public void MultipleObservers_ShouldAllBeNotified() {
        List<String> messages1 = new ArrayList<>();
        List<String> messages2 = new ArrayList<>();
        Observer observer1 = message -> messages1.add(message);
        Observer observer2 = message -> messages2.add(message);
        notificationService.registerObserver(observer1);
        notificationService.registerObserver(observer2);
        notificationService.notifyObservers("Multi observer test");
        assertEquals(1, messages1.size());
        assertEquals(1, messages2.size());
        assertEquals("Multi observer test", messages1.get(0));
        assertEquals("Multi observer test", messages2.get(0));
    }

    @Test
    public void RemoveObserver_ShouldStopNotifications() {
        List<String> messages = new ArrayList<>();
        Observer observer = message -> messages.add(message);
        notificationService.registerObserver(observer);
        notificationService.notifyObservers("Before removal");
        notificationService.removeObserver(observer);
        notificationService.notifyObservers("After removal");
        assertEquals(1, messages.size());
        assertEquals("Before removal", messages.get(0));
    }



    
}

class DummyStatisticsCollector {
    private final java.util.Map<String, Integer> counts = new
            java.util.HashMap<>();

    public void record(String type) {
        counts.put(type, counts.getOrDefault(type, 0) + 1);
    }

    public int getCount(String type) {
        return counts.getOrDefault(type, 0);
    }
}