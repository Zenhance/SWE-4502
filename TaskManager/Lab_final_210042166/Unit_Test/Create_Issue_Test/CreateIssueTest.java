package Lab_final_210042166.Unit_Test.Create_Issue_Test;

import Lab_final_210042166.Task_Management_System.Create_Issue.CreateIssueCommand;
import Lab_final_210042166.Task_Management_System.Enum.Priority;
import Lab_final_210042166.Task_Management_System.Enum.Status;
import Lab_final_210042166.Task_Management_System.Interface.Command;
import Lab_final_210042166.Task_Management_System.Issue.Issue;
import Lab_final_210042166.Task_Management_System.Issue_Repository.IssueRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class CreateIssueTest {

    @Test
    public void CreateIssue_ShouldAddIssueToRepository(){
        IssueRepository repository = IssueRepository.getInstance();
        Issue issue = new Issue("1", "Test Issue", "Description", Priority.MEDIUM, "User1");
        Command createCommand = new CreateIssueCommand(issue, repository);

        createCommand.execute();
        assertNotNull(repository.getIssue("1"));
        assertEquals("Test Issue", repository.getIssue("1").getTitle());
        assertEquals(Status.OPEN, repository.getIssue("1").getStatus());

    }
}
