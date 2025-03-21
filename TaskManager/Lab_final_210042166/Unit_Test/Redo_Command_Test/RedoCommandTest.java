package Lab_final_210042166.Unit_Test.Redo_Command_Test;
import Lab_final_210042166.Task_Management_System.Create_Issue.CreateIssueCommand;
import Lab_final_210042166.Task_Management_System.Enum.Priority;
import Lab_final_210042166.Task_Management_System.Interface.Command;
import Lab_final_210042166.Task_Management_System.Issue.Issue;
import Lab_final_210042166.Task_Management_System.Issue_Repository.IssueRepository;
import Lab_final_210042166.Task_Management_System.Manage_Command.CommandManager;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
public class RedoCommandTest {
    @Test
    public void RedoCommand_ShouldReapplyUndoneAction() {
        IssueRepository repository = IssueRepository.getInstance();
        Issue issue = new Issue("2", "Test Issue", "Testing Redo Command", Priority.HIGH, "User1");
        Command createCommand = new CreateIssueCommand(issue,repository);
        CommandManager manager = new CommandManager();

        manager.executeCommand(createCommand);
        manager.undo();
        manager.redo();

        assertNotNull(repository.getIssue("2"));
    }

}
