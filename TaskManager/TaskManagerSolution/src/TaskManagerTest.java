import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TaskManagerTest {

    private TaskManager taskManager;
    private EmailNotifier emailNotifier;

    @BeforeEach
    void setUp() {
        taskManager = new TaskManager();
        emailNotifier = new EmailNotifier();
        taskManager.registerObserver(emailNotifier);
    }

    @Test
    void testCreateIssue_ShouldAddIssueToRepository() {
        Issue issue = taskManager.createIssue("Test Issue", "Description", Priority.MEDIUM);

        assertNotNull(issue);
        assertNotNull(issue.getId());
        assertEquals("Test Issue", issue.getTitle());
        assertEquals("Description", issue.getDescription());
        assertEquals(Priority.MEDIUM, issue.getPriority());
        assertEquals(Status.OPEN, issue.getStatus());
        assertNotNull(taskManager.getIssue(issue.getId()));
    }

    @Test
    void testAddComment_ShouldAddCommentToIssue() {
        Issue issue = taskManager.createIssue("Test Issue", "Description", Priority.MEDIUM);
        taskManager.addComment(issue.getId(), "Test Comment", "Test Author");
        Issue updatedIssue = taskManager.getIssue(issue.getId());
        assertEquals(1, updatedIssue.getComments().size());
        assertEquals("Test Comment", updatedIssue.getComments().get(0).getContent());
        assertEquals("Test Author", updatedIssue.getComments().get(0).getAuthor());
    }

    




}