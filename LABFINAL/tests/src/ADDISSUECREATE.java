import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ADDISSUECREATE {

    private IssueRepository repository;

    @BeforeEach
    void setUp() {
        repository = new IssueRepository();
    }

    @Test
    void CreateIssue_ShouldAddIssueToRepository() {

        Issue issue = new Issue(1, "Bug Fix", "Fix login issue", "High", "Open", "Alice");
        repository.addIssue(issue);


        Issue retrievedIssue = repository.getIssue(1);
        assertNotNull(retrievedIssue, "Issue should be added to the repository.");
        assertEquals("Bug Fix", retrievedIssue.getTitle(), "Issue title should match.");
        assertEquals("Fix login issue", retrievedIssue.getDescription(), "Issue description should match.");
        assertEquals("High", retrievedIssue.getPriority(), "Issue priority should match.");
        assertEquals("Open", retrievedIssue.getStatus(), "Issue should have the default status 'Open'.");
    }
    
}
