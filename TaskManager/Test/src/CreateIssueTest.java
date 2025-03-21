import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
public class CreateIssueTest {
    private IssueRepository repo;
    private Issue issue;

    @BeforeEach
    void setup() {
        repo = IssueRepository.getInstance();
        issue = new Issue("bug fixing", "A Ui bug was found", Priority.MEDIUM);
        repo.createIssue(issue);
    }

    @Test
    void testcreateIssue() {
        assertNotNull(repo.getIssue(issue.getId()));
    }

    @Test
    void testGetIssue() {
        Issue retrievedIssue = repo.getIssue(issue.getId());
        assertEquals(issue.getId(), retrievedIssue.getId());
    }

    @Test
    void testRemoveIssue() {
        repo.removeIssue(issue.getId());
        assertNull(repo.getIssue(issue.getId()));
    }
}