import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class Create_Issue_Test {

    private IssueRepository repository;
    private IssueService service;

    @Before
    public void setUp() {
        repository = new IssueRepository();
        service = new IssueService(repository);
    }

    @Test
    public void CreateIssue() {
        String title = "Issue1";
        String description = "Issue1 description.";
        String priority = "High";

        CreateIssueCommand command = new CreateIssueCommand(service, title, description, priority);
        command.execute();
        Issue newIssue = command.getCreatedIssue();

        assertNotNull(newIssue);
        assertEquals(title, newIssue.title);
        assertEquals(description, newIssue.description);
        assertEquals(priority, newIssue.priority);
        assertEquals("Open", newIssue.status);
        assertTrue(repository.getAllIssues().containsValue(newIssue));
    }
}