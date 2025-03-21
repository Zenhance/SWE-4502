import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
public class CreateIssueTest {
    @Test
    public void CreateIssue_ShouldAddIssueToRepository(){
        Issue issue= new Issue("First Issue","Completed first issue");

        assertEquals("The issue has been created successfully", issue.createIssue(13,"First Issue","Completed first issue"),"Succesfull");
    }
}
