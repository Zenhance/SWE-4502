import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class IssueRepoTest {

    private Issue issue1;
    private IssueRepository issueRep1;
    @BeforeEach
    public void setup(){
         issue1 = new Issue();
         issueRep1 = new IssueRepository();

    }
    @Test
    public void CreateIssue_ShouldAddIssueToRepository(){
        issue1.setTitle("Issue 1");
        issue1.setDescription("Created Issue 1 Description");
        issue1.setPriority(PriorityType.LOW);

        issueRep1.registerIssue(issue1);

        Command createIssue = new CreateIssueCommand(issue1,issueRep1);
        createIssue.execute();


        Issue test = issueRep1.getIssue(issue1.getId());


        assertEquals("Issue 1", test.getTitle());
        assertEquals("Created Issue 1 Description", test.getDescription());



    }


}
