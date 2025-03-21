import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class IssueRepositoryTest {
    @Test
    public void CreateIssue_ShouldAddIssueToRepository()
    {
        IssueRepository repository = new IssueRepository();
        Issue issue = new Issue("LabFinal", "Final Lab for Java", "Hamim");
        repository.addIssue(issue);
        var searchedIssue = repository.getIssue(issue.getId());
        assertTrue(searchedIssue.id == issue.id);
        assert


    }
}