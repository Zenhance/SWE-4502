import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNull;

public class testF04 {

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
    public void testF04_UndoCommand_ShouldRevertLastAction() {
        Issue issue = new Issue(1, "Bug", "Crash", Priority.HIGH);
        Command cmd = new CreateIssueCommand(repo, issue, logger, notifier, stats);
        manager.executeCommand(cmd);
        manager.undo();
        assertNull(repo.getIssue(issue.getId()));
    }
}
