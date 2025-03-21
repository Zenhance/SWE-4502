import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Date;

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




    // my first test #f01
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

    // my second test #f02
    @Test
    void addComment_ShouldAddCommentToIssue() {
        Issue issue = new Issue("F01", "Test Issue", "Test Description", Priority.HIGH, Status.OPEN, new Date(), new Date(), "John Doe", null, null);
        Comment comment = new Comment("1", "Test Comment", "Author", new Date());

        issue.addComment(comment);

        assertTrue(issue.getComments().contains(comment), "The comment should be added to the issue.");
        assertEquals("Test Comment", issue.getComments().get(0).getContent(), "The comment content should match.");
        assertEquals("Author", issue.getComments().get(0).getAuthor(), "The comment author should match.");
    }





























}
