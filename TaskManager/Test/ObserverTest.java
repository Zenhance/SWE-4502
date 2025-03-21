package test;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import patterns.IssueMediator;
import patterns.User;

public class ObserverTest {
    @Test
    public void Observer_ShouldBeNotifiedOfCommands() {
        IssueMediator mediator = new IssueMediator();
        User user = new User("Alice");

    }
}