import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class CreateIssue_ShouldAddIssueToRepository {

    @Test
    public void CreateIssue_ShouldAddIssueToRepositoryTest() {
        IssueRepository repository = new IssueRepository();
        Issue issue = new Issue(1, "Issue 1", "Description", "High", "Open", new Date(), new Date(), "User1", null, null);
        Command createIssueCommand = new CreateIssueCommand(repository, issue);
        CommandInvoker invoker = new CommandInvoker();
        invoker.executeCommand(createIssueCommand);

        assertNotNull(repository.getIssue(1));
        assertEquals("High", repository.getIssue(1).getPriority());
        assertEquals("Open", repository.getIssue(1).getStatus());
    }
}
