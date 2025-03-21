import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class ChangeStatusTest {
    private IssueRepository issueRepository;
    private TaskManager taskManager;

    @BeforeEach
    void setUp() {
        issueRepository = new IssueRepository();
        taskManager = new TaskManager(issueRepository, new StatisticsCollector());
    }

    @Test
    void changeStatus_ShouldUpdateIssueStatus() {

        Issue issue = new Issue("1", "Bug Fix", "Fix the login issue", "High", "Open");
        ChangeIssueCommand changeStatusCommand = new ChangeIssueCommand(issue, issueRepository, "Open", "In Progress");

        taskManager.executeCommand(changeStatusCommand);

        assertEquals("In Progress", issue.getStatus());
    }
}
