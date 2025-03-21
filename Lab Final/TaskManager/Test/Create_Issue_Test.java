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
    public void CreateIssue_ShouldAddIssueToRepository() {

        String title = "Issue1";
        String description = "Issue1 description.";
        String priority = "High";
        Issue newIssue = service.createIssue(title, description, priority);
        assertNotNull(newIssue);
        assertEquals(title, newIssue.title);
        assertEquals(description, newIssue.description);
        assertEquals(priority, newIssue.priority);
        assertEquals("Open", newIssue.status);
        assertTrue(repository.getAllIssues().containsValue(newIssue));
    }
}