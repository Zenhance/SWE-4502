import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class Change_Status_Test {

    private IssueRepository repository;
    private IssueService service;

    @Before
    public void setUp() {
        repository = new IssueRepository();
        service = new IssueService(repository);
    }

    @Test
    public void ChangeStatus() {
        String title = "Issue1";
        String description = "Issue1 description.";
        String priority = "High";
        CreateIssueCommand command = new CreateIssueCommand(service, title, description, priority);
        command.execute();
        Issue newIssue = command.getCreatedIssue();
        String status = "Closed";
        ChangeStatusCommand changeStatusCommand = new ChangeStatusCommand(service, newIssue.ID, status);
        changeStatusCommand.execute();
        Issue updatedIssue = repository.getIssue(newIssue.ID);
        assertEquals(status, updatedIssue.status);
    }
}


