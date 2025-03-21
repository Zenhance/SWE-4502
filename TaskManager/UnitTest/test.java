import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class test {
    private IssueRepository repository;
    private Command c1;
    private ChangeStatus c2;
    private Issuenotifer notifier;

    @BeforeEach
    void setUp() {
        repository = new IssueRepository();
        c1 = new CreateIssue(repository, "Bug Fix", "Fix login   issue", Priority.High);
        notifier = new Issuenotifer();

    }

    @Test
    void testCreateIssue() {

        c1.execute();
        assertNotNull(repository.getIssue(1), "Issue should be created.");
        assertEquals(1, repository.getIssueCount(), "Issue count should be 1.");
    }


    @Test
    void ChangeStausTest()
    {


    }
}
