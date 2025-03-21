package labFinal_164.test;

import labFinal_164.command.CreateIssueCommand;
import labFinal_164.model.Issue;
import labFinal_164.model.Priority;
import labFinal_164.model.Status;
import labFinal_164.repository.IssueRepository;
import labFinal_164.service.CommandManager;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;


public class CreateIssueTest {
    private IssueRepository repository;
    private CommandManager manager;

    @BeforeEach
    void setup() {
        repository = new IssueRepository();
        manager = new CommandManager(repository);
    }

    @Test
    void CreateIssue_ShouldAddIssueToRepository() {
        Issue issue = new Issue("ISSUE-1", "Test Title", "Test Desc", Priority.HIGH);
        manager.executeCommand(new CreateIssueCommand(repository, issue));
        Issue savedIssue = repository.getIssue("ISSUE-1");
        assertNotNull(savedIssue);
        assertEquals("Test Title", savedIssue.getTitle());
        assertEquals(Status.OPEN, savedIssue.getStatus());

    }








    }
