package test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

import main.core.Issue;
import main.commands.IssueCreateCommand;
import main.features.IssueRepository;

public class Issue1 {

    @Test
    public void CreateIssue_ShouldAddIssueToRepository() {
        Issue i = new Issue("issue#1", "The very first issue", "hasin023");
        System.out.println(i.GetId());
        IssueRepository ir = new IssueRepository();
        IssueCreateCommand icc = new IssueCreateCommand(i, ir);
        icc.execute();

        Issue foundIssue = ir.GetIssueFromRepository(i.GetId());
        System.out.println(foundIssue.GetId());

        assertEquals(i.GetTitle(), foundIssue.GetTitle());
    }

}