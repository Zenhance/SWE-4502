import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ChangeStatusTest {
    private IssueRepository repository;
    private Command c1;



    @BeforeEach
    void setUp() {
        repository = new IssueRepository();
        c1 = new CreateIssue(repository, "Easy Bug Fix", "logout issue", Priority.Low);


    }

    @Test
    void testChangeStatus() {

        Command createIssue = new CreateIssue(repository, "Performance  Improvement", "Optimize database queries", Priority.Medium);
        c1.execute();


        Issue issue = repository.getIssue(1);

        assertEquals(Status.Open, issue.getStatus(), "Default status should be Open.");

        Command c1 = new ChangeStatus(issue, Status.Resolved);
        c1.execute();

        assertEquals( Status.Resolved, issue.getStatus(), "Status should be changed to Resolved.");
    }

}
