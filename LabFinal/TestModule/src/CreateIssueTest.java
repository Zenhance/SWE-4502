import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class CreateIssueTest {

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
    public void createIssueTest() {
        Issue issue = new Issue(1, "Bug", "App crashes", Priority.HIGH);
        Command cmd = new CreateIssueCommand(repo, issue, logger, notifier, stats);
        manager.executeCommand(cmd);

        assertNotNull(repo.getIssue(issue.getId()));
        assertEquals(Status.OPEN, repo.getIssue(issue.getId()).getStatus());
    }
}
