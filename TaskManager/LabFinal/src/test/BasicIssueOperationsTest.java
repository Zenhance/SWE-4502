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

    //#F01
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

    //#F02
    @Test
    void AddComment_ShouldAddCommentToIssue() {
        String issueId = taskManager.createIssue("Test Issue 1", "Hellowwwwwwww", Priority.Medium);
        taskManager.addComment(issueId, "This is a comment", "John Doe");

        Issue issue = taskManager.getIssue(issueId);
        assertNotNull(issue);
        assertEquals(1, issue.getComments().size());
        assertEquals("This is a comment", issue.getComments().get(0).getContent());
        assertEquals("John Doe", issue.getComments().get(0).getAuthor());
    }

    //#F03
    @Test
    void changeStatus_ShouldUpdateIssueStatus() {
        String issueId = taskManager.createIssue("Status testing Issue", "bla bla bla", Priority.Medium);
        taskManager.changeStatus(issueId, Status.InProgress);

        Issue issue = taskManager.getIssue(issueId);
        assertEquals(Status.InProgress, issue.getStatus());
    }

}