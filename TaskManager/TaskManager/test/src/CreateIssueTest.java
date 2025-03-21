import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CreateIssueTest{
    @Test
    void testIssueCreation(){
        IssueRepository issueRepository=new IssueRepository();
        Issue issue=new Issue("CreateTest","Testing the creation of issues",High);

        int Id=1;

        issueRepository.create(Id,isssue);
        assertEquals(True,issueRepository.getCreation());
    }
}