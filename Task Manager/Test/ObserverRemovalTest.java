import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ObserverRemovalTest {
    private IssueRepository issueRepository;
    private TaskManager taskManager;

    @BeforeEach
    void setUp() {
        issueRepository = new IssueRepository();
        taskManager = new TaskManager(issueRepository, new StatisticsCollector());
    }

    @Test
    void removeObserver_ShouldStopNotifications() {

        Issue issue = new Issue("1", "Bug Fix", "Fix the login issue", "High", "Open");
        NotificationService notificationService = new NotificationService("user@example.com");
        issue.addObserver(notificationService);
        issue.removeObserver(notificationService);

        ChangeIssueCommand changeStatusCommand = new ChangeIssueCommand(issue, issueRepository, "Open", "In Progress");

        taskManager.executeCommand(changeStatusCommand);

    }
}
