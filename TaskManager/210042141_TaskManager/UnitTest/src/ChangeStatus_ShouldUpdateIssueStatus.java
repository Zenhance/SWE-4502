import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.assertEquals;

public class ChangeStatus_ShouldUpdateIssueStatus {
    @Test
    public void ChangeStatus_ShouldUpdateIssueStatusTest() {
        IssueRepository repository = new IssueRepository();
        Issue issue = new Issue(1, "Issue 1", "Description", "High", "Open", new Date(), new Date(), "FirstUser", null, null);
        repository.addIssue(issue);

        issue.setStatus("InProgress");
        assertEquals("InProgress", issue.getStatus());
    }

}
