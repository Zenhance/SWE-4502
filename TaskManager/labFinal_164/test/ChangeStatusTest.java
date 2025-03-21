package labFinal_164.test;

import labFinal_164.command.ChangeStatusCommand;
import labFinal_164.command.CreateIssueCommand;
import labFinal_164.model.Issue;
import labFinal_164.model.Priority;
import labFinal_164.model.Status;
import labFinal_164.repository.IssueRepository;
import labFinal_164.service.CommandManager;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.Assert.assertEquals;

public class ChangeStatusTest {
    private IssueRepository repository;
    private CommandManager manager;

    @BeforeEach
    void setup() {
        repository = new IssueRepository();
        manager = new CommandManager(repository);
        manager.executeCommand(new CreateIssueCommand(repository,
                new Issue("ISSUE-1", "Test", "Desc", Priority.LOW)));
    }

    @Test
    void ChangeStatus_ShouldUpdateIssueStatus() {
        manager.executeCommand(new ChangeStatusCommand(repository, "ISSUE-1", Status.IN_PROGRESS));
        assertEquals(Status.IN_PROGRESS, repository.getIssue("ISSUE-1").getStatus());

    }

}
