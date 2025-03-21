package test.test.com.taskmanager;

import com.taskmanager.model.Issue;
import com.taskmanager.model.Priority;
import com.taskmanager.model.Status;
import com.taskmanager.repository.IssueRepository;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CreateIssueTest {

    @Test
    public void CreateIssue_ShouldAddIssueToRepository() {
        IssueRepository repository = new IssueRepository();
        Issue issue = new Issue();
        issue.setId("1");
        issue.setTitle("Test Issue");
        issue.setDescription("This is a test issue");
        issue.setPriority(Priority.MEDIUM);

        repository.addIssue(issue);

        Issue retrievedIssue = repository.getIssue("1");
        assertNotNull(retrievedIssue);
        assertEquals("Test Issue", retrievedIssue.getTitle());
        assertEquals("This is a test issue", retrievedIssue.getDescription());
        assertEquals(Priority.MEDIUM, retrievedIssue.getPriority());
        assertEquals(Status.OPEN, retrievedIssue.getStatus()); // Default status
    }
}