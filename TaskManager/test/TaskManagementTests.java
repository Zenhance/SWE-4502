import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;

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


}