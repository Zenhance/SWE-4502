import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MultipleObserversTest {
    private IssueRepository issueRepository;
    private TaskManager taskManager;

    @BeforeEach
    void setUp() {
        issueRepository = new IssueRepository();
        taskManager = new TaskManager(issueRepository, new StatisticsCollector());
    }

    @Test
    void multipleObservers_ShouldAllBeNotified() {

        Issue issue = new Issue("1", "Bug Fix", "Fix the login issue", "High", "Open");
        NotificationService notificationService1 = new NotificationService("user1@example.com");
        NotificationService notificationService2 = new NotificationService("user2@example.com");
        issue.addObserver(notificationService1);
        issue.addObserver(notificationService2);

        ChangeIssueCommand changeStatusCommand = new ChangeIssueCommand(issue, issueRepository, "Open", "In Progress");

        taskManager.executeCommand(changeStatusCommand);
    }
}
