package test.test.com.taskmanager;

import com.taskmanager.command.Command;
import com.taskmanager.command.CommandManager;
import com.taskmanager.command.CreateIssueCommand;
import com.taskmanager.model.Issue;
import com.taskmanager.repository.IssueRepository;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class RedoCommandTest {

    @Test
    public void RedoCommand_ShouldReapplyUndoneAction() {
        IssueRepository repository = new IssueRepository();
        CommandManager commandManager = new CommandManager();

        Issue issue = new Issue();
        issue.setId("1");
        issue.setTitle("Test Issue");

        Command createCommand = new CreateIssueCommand(repository, issue);
        commandManager.executeCommand(createCommand);
        commandManager.undoCommand();
        commandManager.redoCommand();

        assertNotNull(repository.getIssue("1"));
    }
}