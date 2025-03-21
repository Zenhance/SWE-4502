package test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

import main.core.Issue;
import main.commands.IssueCreateCommand;
import main.features.IssueRepository;

public class AppTest {

    @Test
    public void CreateIssue_ShouldAddIssueToRepository() {
        Issue i = new Issue("issue#1", "The very first issue", "hasin023");
        IssueRepository ir = new IssueRepository();
        IssueCreateCommand icc = new IssueCreateCommand(i, ir);
        icc.execute();

        Issue foundIssue = ir.GetIssueFromRepository(i.GetId());

        assertEquals(i.GetTitle(), foundIssue.GetTitle());
    }

}