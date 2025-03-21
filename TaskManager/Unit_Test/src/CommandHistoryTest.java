import org.junit.jupiter.api.Test;

public class CommandHistoryTest {

    @Test
    void commandHistory_ShouldTrackAllExecutedCommands() {
        CreateIssueCommand createCommand = new CreateIssueCommand(repository, testIssue);
        commandManager.executeCommand(createCommand);
        commandManager.undo();
        commandManager.redo();

        assertNotNull(repository.getIssue(testIssue.id));
    }


}
