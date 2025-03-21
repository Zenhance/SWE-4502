import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class Add_Comment_Test {

    private IssueRepository repository;
    private IssueService service;

    @Before
    public void setUp() {
        repository = new IssueRepository();
        service = new IssueService(repository);
    }

    @Test
    public void AddComment() {
        String title = "Issue1";
        String description = "Issue1 description.";
        String priority = "High";
        CreateIssueCommand command = new CreateIssueCommand(service, title, description, priority);
        command.execute();
        Issue newIssue = command.getCreatedIssue();
        String content = "Comment1";
        String author = "Author1";
        AddCommentCommand addCommentCommand = new AddCommentCommand(service, newIssue.ID, content, author);
        addCommentCommand.execute();
        Issue updatedIssue = addCommentCommand.getAddedComment();
        assertEquals(newIssue.comments.size(), updatedIssue.comments.size());
        assertTrue(updatedIssue.comments.stream().anyMatch(c -> c.content.equals(content) && c.author.equals(author)));
    }

}
