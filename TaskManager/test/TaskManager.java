import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class test {
    private IssueRepo repository;
    private ICommand c1;



    @BeforeEach
    void setUp() {
        repository = new IssueRepo();
        c1 = new CreateIssue(repository, "Bug Fix", "Fix login   issue", Priority.High);


    }

    @Test
    void testCreateIssue() {

        c1.execute();
        assertNotNull(repository.getIssue(1), "Issue should be created.");
        assertEquals(1, repository.getIssueCount(), "Issue count should be 1.");
    }


}