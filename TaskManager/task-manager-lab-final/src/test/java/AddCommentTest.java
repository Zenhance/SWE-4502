import commands.AddCommentCommand;
import commands.CreateIssueCommand;
import db.IssueReposity;
import models.Issue;
import models.Priority;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import subjects.CommandManager;

import static org.junit.jupiter.api.Assertions.*;

public class AddCommentTest {
    private IssueReposity repository;
    private CommandManager commandManager;
    private Issue testIssue;

    @BeforeEach
    public void setUp() {
        repository = new IssueReposity();
        commandManager = new CommandManager();
        testIssue = new Issue();
        testIssue.setId("1");
        testIssue.setTitle("Test Issue");
        testIssue.setDescription("Test Description");
        testIssue.setPriority(Priority.MEDIUM);

        CreateIssueCommand createCommand = new CreateIssueCommand(repository, testIssue);
        commandManager.executeCommand(createCommand);
    }

    @Test
    public void AddComment_ShouldAddCommentToIssue() {
        String content = "This is a test comment";
        String author = "Test User";

        AddCommentCommand command = new AddCommentCommand(repository, "1", content, author);
        commandManager.executeCommand(command);

        Issue retrievedIssue = repository.getIssue("1");
        assertNotNull(retrievedIssue, "Issue should exist");
        assertEquals(1, retrievedIssue.getComments().size(), "Issue should have one comment");
        assertEquals(content, retrievedIssue.getComments().get(0).getContent(), "Comment content should match");
        assertEquals(author, retrievedIssue.getComments().get(0).getAuthor(), "Comment author should match");
    }
}