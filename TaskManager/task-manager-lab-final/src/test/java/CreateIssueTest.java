import commands.CreateIssueCommand;
import db.IssueReposity;
import models.Issue;
import models.Priority;
import subjects.CommandManager;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class CreateIssueTest {
    private IssueReposity repository;
    private CommandManager commandManager;

    @BeforeEach
    public void setUp() {
        repository = new IssueReposity();
        commandManager = new CommandManager();
    }

    @Test
    public void CreateIssue_ShouldAddIssueToRepository() {
        Issue issue = new Issue();
        issue.setId("1");
        issue.setTitle("Test Issue");
        issue.setDescription("This is a test issue");
        issue.setPriority(Priority.MEDIUM);

        CreateIssueCommand command = new CreateIssueCommand(repository, issue);
        commandManager.executeCommand(command);

        Issue retrievedIssue = repository.getIssue("1");
        assertNotNull(retrievedIssue, "Issue should exist in repository");
        assertEquals("Test Issue", retrievedIssue.getTitle(), "Title should match");
        assertEquals("This is a test issue", retrievedIssue.getDescription(), "Description should match");
        assertEquals(Priority.MEDIUM, retrievedIssue.getPriority(), "Priority should match");
    }
}