import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNull;

class UndoCommandTest {
    private IssueRepository issueRepository;
    private TaskManager taskManager;

    @BeforeEach
    void setUp() {
        issueRepository = new IssueRepository();
        taskManager = new TaskManager(issueRepository, new StatisticsCollector());
    }

    @Test
    void undoCommand_ShouldRevertLastAction() {

        Issue issue = new Issue("1", "Bug Fix", "Fix the login issue", "High", "Open");
        CreateIssueCommand createIssueCommand = new CreateIssueCommand(issue, issueRepository);
        taskManager.executeCommand(createIssueCommand);

        taskManager.undoCommand();

        assertNull(issueRepository.getIssueById(issue.getId()));
    }
}
