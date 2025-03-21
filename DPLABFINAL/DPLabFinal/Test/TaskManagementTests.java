import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TaskManagementTests {

    private IssueRepository repository;
    private CommandInvoker invoker;
    private CommandLogger logger;
    private NotificationService notificationService;
    private Issue issue;
    private Comment comment;

    @BeforeEach
    void setup() {
        repository = new IssueRepository();
        invoker = new CommandInvoker();
        logger = new CommandLogger();
        notificationService = new NotificationService();
        issue = new Issue("F01", "Test Issue", "Test Description", Priority.HIGH);
        comment = new Comment("1", "Test Comment", "Author", new java.util.Date());
    }





    @Test
    void createIssue_ShouldAddIssueToRepository() {
        Issue issue = new Issue("F01", "Test Issue", "Test Description", Priority.HIGH);
        IssueRepository repository = new IssueRepository();
        CreateIssueCommand createCommand = new CreateIssueCommand(repository, issue);

        createCommand.execute();

        Issue retrievedIssue = repository.getIssue("F01");
        System.out.println("Retrieved Issue: " + (retrievedIssue != null ? retrievedIssue.getTitle() : "Issue not found"));

        assertNotNull(retrievedIssue, "The issue should be added to the repository.");
        assertEquals("Test Issue", retrievedIssue.getTitle(), "The issue title should match.");
        assertEquals("Test Description", retrievedIssue.getDescription(), "The issue description should match.");
    }



























}
