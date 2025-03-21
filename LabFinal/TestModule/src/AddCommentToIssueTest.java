import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class AddCommentToIssueTest {

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
    public void AddComment_ShouldAddCommentToIssue() {
        Issue issue = new Issue(1, "Bug", "Crash", Priority.HIGH);
        repo.addIssue(issue);

        Comment comment = new Comment("Fix ASAP", "Sani");
        issue.addComment(comment);

        assertNotNull(issue.getComments());
        assertEquals(1, issue.getComments().size());
        assertEquals("Sani", issue.getComments().get(0).getAuthor());

    }

}
