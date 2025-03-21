import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

class CommandLoggingTest {
    private Logger logger;

    @BeforeEach
    void setUp() {
        logger = new Logger();
    }

    @Test
    void logger_ShouldStoreCommandHistoryLogs() {

        Issue issue = new Issue("1", "Bug Fix", "Fix the login issue", "High", "Open");
        CreateIssueCommand createIssueCommand = new CreateIssueCommand(issue, new IssueRepository());

        createIssueCommand.execute();
        logger.logOperation("Create Issue - " + issue.getId());

        assertTrue(logger.getLogs().size() > 0);
    }
}
