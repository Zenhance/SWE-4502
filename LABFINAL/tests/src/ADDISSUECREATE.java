import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class AddIssueCreateTest {

    private IssueRepository repository;

    @BeforeEach
    void setUp() {
        repository = new IssueRepository();
    }

    @Test
    void CreateIssue_ShouldAddIssueToRepository() {
        Issue issue = new Issue(1, "Bug Fix", "Fix login issue", Priority.HIGH, Status.OPEN, "Alice");
        repository.addIssue(issue);

        Issue retrievedIssue = repository.getIssue(1);
        assertNotNull(retrievedIssue, "Issue should be added to the repository.");
        assertEquals("Bug Fix", retrievedIssue.getTitle(), "Issue title should match.");
        assertEquals("Fix login issue", retrievedIssue.getDescription(), "Issue description should match.");
        assertEquals(Priority.HIGH, retrievedIssue.getPriority(), "Issue priority should match.");
        assertEquals(Status.OPEN, retrievedIssue.getStatus(), "Issue status should match.");
    }

    @Test
    void AddComment_ShouldAddCommentToIssue() {
        Issue issue = new Issue(1, "Bug Fix", "Fix login issue", Priority.HIGH, Status.OPEN, "Alice");
        repository.addIssue(issue);

        Comment comment = new Comment(1, "This is a comment", "User1");
        issue.addComment(comment);

        List<Comment> comments = issue.getComments();
        assertEquals(1, comments.size(), "Comment list size should be 1");
        assertEquals("This is a comment", comments.get(0).getContent(), "Comment content mismatch");
        assertEquals("User1", comments.get(0).getAuthor(), "Comment author mismatch");
    }
}

