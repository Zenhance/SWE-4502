package test;

import models.Issue;
import commands.ChangeStatusCommand;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class InvalidStatusChangeTest {
    @Test
    public void InvalidStatusChange_ShouldThrowException() {
        Issue issue = new Issue(1, "Bug Fix", "Fix login issue", "High");

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new ChangeStatusCommand(issue, "InvalidStatus").execute();
        });

        assertEquals("Invalid status", exception.getMessage());
}
}