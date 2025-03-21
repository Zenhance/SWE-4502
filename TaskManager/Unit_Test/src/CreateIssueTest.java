import org.junit.jupiter.api.Test;

public class CreateIssueTest {
        @Test
        void createIssue_ShouldAddIssueToRepository() {
            CreateIssueCommand command = new CreateIssueCommand(repository, testIssue);
            commandManager.executeCommand(command);

            Issue retrievedIssue = repository.getIssue(testIssue.id);
            assertNotNull(retrievedIssue);
            assertEquals("Bug Fix", retrievedIssue.title);
            assertEquals(Issue.Status.OPEN, retrievedIssue.status);
        }

    }

