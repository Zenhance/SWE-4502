package test;

import models.Issue;
import models.IssueRepository;
import commands.CreateIssueCommand;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CreateIssueTest {
    @Test
    public void CreateIssue_ShouldAddIssueToRepository() {
        IssueRepository repository = new IssueRepository();
        Issue issue = new Issue(1, "Bug Fix", "Fix login issue", "High");
        CreateIssueCommand command = new CreateIssueCommand(repository, issue);

        command.execute();
        assertNotNull(repository.getIssue(1));
        assertEquals("Bug Fix", repository.getIssue(1).getTitle());
        assertEquals("Open", repository.getIssue(1).getStatus());
    }
}

