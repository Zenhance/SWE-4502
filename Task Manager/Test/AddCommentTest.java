import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

class AddCommentTest {
    private IssueRepository issueRepository;
    private TaskManager taskManager;

    @BeforeEach
    void setUp() {
        issueRepository = new IssueRepository();
        taskManager = new TaskManager(issueRepository, new StatisticsCollector());
    }

    @Test
    void addComment_ShouldAddCommentToIssue() {

        Issue issue = new Issue("1", "Bug Fix", "Fix the login issue", "High", "Open");
        Comment comment = new Comment("1", "This is a very faltu bug to fix.", "Antara");
        AddCommentCommand addCommentCommand = new AddCommentCommand(issue, comment, issueRepository);

        taskManager.executeCommand(addCommentCommand);

        assertTrue(issue.getComments().contains(comment));
    }
}
