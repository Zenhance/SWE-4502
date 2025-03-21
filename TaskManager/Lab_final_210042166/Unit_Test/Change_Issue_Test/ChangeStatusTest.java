package Lab_final_210042166.Unit_Test.Change_Issue_Test;
import Lab_final_210042166.Task_Management_System.Change_Issue.ChangeStatusCommand;
import Lab_final_210042166.Task_Management_System.Enum.Priority;
import Lab_final_210042166.Task_Management_System.Enum.Status;
import Lab_final_210042166.Task_Management_System.Interface.Command;
import Lab_final_210042166.Task_Management_System.Issue.Issue;
import Lab_final_210042166.Task_Management_System.Issue_Repository.IssueRepository;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ChangeStatusTest {
    @Test
    public void ChangeStatus_ShouldUpdateIssueStatus() {
        IssueRepository repository = IssueRepository.getInstance();
        Issue issue = new Issue("1", "Test Issue", "Description", Priority.MEDIUM, "User1");
        repository.addIssue(issue);

        Command changeStatusCommand = new ChangeStatusCommand(issue, Status.IN_PROGRESS, repository);
        changeStatusCommand.execute();
        assertEquals(Status.IN_PROGRESS, repository.getIssue("1").getStatus());
    }

}
