import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class ChangeIssueStatusTest {

    private IssueRepository repo;
    private Logger logger;
    private NotificationService notifier;
    private StatisticsCollector stats;
    private CommandManager manager;
    private List<String> notifications;

    @BeforeEach
    public void setup() {
        repo = new IssueRepository();
        logger = new Logger();
        notifier = new NotificationService();
        stats = new StatisticsCollector();
        manager = new CommandManager();

        notifications = new ArrayList<>();
        notifier.register(message -> notifications.add(message));
    }


    @Test
    public void testF03_ChangeStatus_ShouldUpdateIssueStatus() {
        Issue issue = new Issue(1, "Bug", "Crash", Priority.HIGH);
        repo.addIssue(issue);
        issue.setStatus(Status.RESOLVED);
        assertEquals(Status.RESOLVED, issue.getStatus());
    }
}







