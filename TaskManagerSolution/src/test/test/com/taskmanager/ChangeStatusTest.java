package test.test.com.taskmanager;

import com.taskmanager.model.Issue;
import com.taskmanager.model.Status;
import com.taskmanager.repository.IssueRepository;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ChangeStatusTest {

    @Test
    public void ChangeStatus_ShouldUpdateIssueStatus() {
        IssueRepository repository = new IssueRepository();
        Issue issue = new Issue();
        issue.setId("1");
        issue.setStatus(Status.OPEN);
        repository.addIssue(issue);

        issue.setStatus(Status.IN_PROGRESS);
        repository.updateIssue(issue);

        Issue retrievedIssue = repository.getIssue("1");
        assertEquals(Status.IN_PROGRESS, retrievedIssue.getStatus());
    }
}