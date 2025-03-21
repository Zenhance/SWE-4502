package test;

import models.Issue;
import patterns.User;
import patterns.IssueMediator;
import commands.ChangeStatusCommand;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MultipleObserversTest {
    @Test
    public void MultipleObservers_ShouldAllBeNotified() {
        Issue issue = new Issue(1, "Bug Fix", "Fix login issue", "High");
        IssueMediator mediator = new IssueMediator();
        User user1 = new User("Alice");
        User user2 = new User("Bob");

        mediator.addObserver(user1);
        mediator.addObserver(user2);
        ChangeStatusCommand command = new ChangeStatusCommand(issue, "Resolved");
        command.setMediator(mediator);

        command.execute();

        assertEquals(1, user1.getNotificationCount());
        assertEquals(1, user2.getNotificationCount());
    }
}