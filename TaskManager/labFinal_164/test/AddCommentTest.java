package labFinal_164.test;

import labFinal_164.command.AddCommentCommand;
import labFinal_164.command.CreateIssueCommand;
import labFinal_164.model.Issue;
import labFinal_164.model.Priority;
import labFinal_164.repository.IssueRepository;
import labFinal_164.service.CommandManager;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class AddCommentTest {
    private IssueRepository repository;
    private CommandManager manager;

    @BeforeEach
    void setup() {
        repository = new IssueRepository();
        manager = new CommandManager(repository);
        manager.executeCommand(new CreateIssueCommand(repository,
                new Issue("ISSUE-1", "Test", "Desc", Priority.MEDIUM)));
    }

    @Test
    void AddComment_ShouldAddCommentToIssue() {
        manager.executeCommand(new AddCommentCommand(repository, "ISSUE-1", "Fix this", "Alice"));
        Issue issue = repository.getIssue("ISSUE-1");
        assertEquals(1, issue.getComment().size());
        assertEquals("Alice", issue.getComment().get(0).getAuthor());
    }



}
