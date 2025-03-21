import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CreateIssueTest {
    private IssueRepository issueRepository;
    private TaskManager taskManager;

    @BeforeEach
    void setUp() {
        issueRepository = new IssueRepository();
        taskManager = new TaskManager(issueRepository, new StatisticsCollector());
    }

    @Test
    void createIssue_ShouldAddIssueToRepository() {

        Issue issue = new Issue("1", "Bug Fix", "Fix the login issue", "High", "Open");
        CreateIssueCommand createIssueCommand = new CreateIssueCommand(issue, issueRepository);

        taskManager.executeCommand(createIssueCommand);

        Issue retrievedIssue = issueRepository.getIssueById(issue.getId());
        assertNotNull(retrievedIssue);
        assertEquals("Bug Fix", retrievedIssue.getTitle());
        assertEquals("Open", retrievedIssue.getStatus());
    }
}
