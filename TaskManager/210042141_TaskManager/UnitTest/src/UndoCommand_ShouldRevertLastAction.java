import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.assertNull;

public class UndoCommand_ShouldRevertLastAction {
    @Test
    public void UndoCommand_ShouldRevertLastActionTest() {
        IssueRepository repository = new IssueRepository();
        Issue issue = new Issue(1, "Issue 1", "this is the escription", "High", "Open", new Date(), new Date(), "Firstuser", null, null);
        Command createIssueCommand = new CreateIssueCommand(repository, issue);

        CommandInvoker invoker = new CommandInvoker();
        invoker.executeCommand(createIssueCommand);
        invoker.undo();

        assertNull(repository.getIssue(1));
    }

}
