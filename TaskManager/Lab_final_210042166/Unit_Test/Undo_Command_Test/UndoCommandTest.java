package Lab_final_210042166.Unit_Test.Undo_Command_Test;
import Lab_final_210042166.Task_Management_System.Create_Issue.CreateIssueCommand;
import Lab_final_210042166.Task_Management_System.Enum.Priority;
import Lab_final_210042166.Task_Management_System.Interface.Command;
import Lab_final_210042166.Task_Management_System.Issue.Issue;
import Lab_final_210042166.Task_Management_System.Issue_Repository.IssueRepository;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class UndoCommandTest {
    @Test
    public void UndoCommand_ShouldRevertLastAction() {
        IssueRepository repository = IssueRepository.getInstance();
        Issue issue = new Issue("2", "Test Issue", "Testing Undo Command", Priority.HIGH, "User1");
        Command createCommand = new CreateIssueCommand(issue, repository);

        createCommand.execute();
        createCommand.undo();

        assertNull(repository.getIssue("2"));
    }

}
