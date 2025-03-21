package test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import taskmanager.TaskManager;
import model.Issue;
import model.Priority;
import model.Status;
import static org.junit.jupiter.api.Assertions.*;

public class BasicIssueOperationsTest {
    private TaskManager taskManager;

    @BeforeEach
    void setUp() {
        taskManager = new TaskManager();
    }

    @Test
    void createIssue_ShouldAddIssueToRepository() {
        String issueId = taskManager.createIssue("Test Issue 1", "Hellowwwwwwww", Priority.Medium);

        Issue issue = taskManager.getIssue(issueId);
        assertNotNull(issue);
        assertEquals("Test Issue 1", issue.getTitle());
        assertEquals("Hellowwwwwwww", issue.getDescription());
        assertEquals(Priority.Medium, issue.getPriority());
        assertEquals(Status.Open, issue.getStatus());
    }

}