package test;

import models.Issue;
import patterns.User;
import patterns.IssueMediator;
import commands.ChangeStatusCommand;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ObserverTest {
    @Test
    public void Observer_ShouldBeNotifiedOfCommands() {
        Issue issue = new Issue(1, "Bug Fix", "Fix login issue", "High");
        IssueMediator mediator = new IssueMediator();
        User user = new User("John Doe");

        mediator.addObserver(user);
        ChangeStatusCommand command = new ChangeStatusCommand(issue, "Resolved");
        command.setMediator(mediator);

        command.execute();
        assertTrue(user.hasReceivedNotification());
    }
}