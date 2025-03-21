import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ObserverNotificationTest {
    private IssueRepository issueRepository;
    private TaskManager taskManager;

    @BeforeEach
    void setUp() {
        issueRepository = new IssueRepository();
        taskManager = new TaskManager(issueRepository, new StatisticsCollector());
    }

    @Test
    void observer_ShouldBeNotifiedOfCommands() {
        // Arrange
        Issue issue = new Issue("1", "Bug Fix", "Fix the login issue", "High", "Open");
        NotificationService notificationService = new NotificationService("user@example.com");
        issue.addObserver(notificationService);
        ChangeIssueCommand changeStatusCommand = new ChangeIssueCommand(issue, issueRepository, "Open", "In Progress");

        taskManager.executeCommand(changeStatusCommand);

    }
}
