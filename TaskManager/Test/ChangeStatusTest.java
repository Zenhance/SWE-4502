package test;

import models.Issue;
import commands.ChangeStatusCommand;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ChangeStatusTest {
    @Test
    public void ChangeStatus_ShouldUpdateIssueStatus() {
        Issue issue = new Issue(1, "Bug Fix", "Fix login issue", "High");
        ChangeStatusCommand command = new ChangeStatusCommand(issue, "Resolved");

        command.execute();
        assertEquals("Resolved", issue.getStatus());
    }
}