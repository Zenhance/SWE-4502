package test;

import models.IssueRepository;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class EmptyIssueRepositoryTest {
    @Test
    public void EmptyIssueRepository_ShouldReturnNull() {
        IssueRepository repository = new IssueRepository();

        // Ensure no issue is found for an arbitrary id (99)
        assertNull(repository.getIssue(99), "The repository should return null for an issue that doesn't exist.");
    }
}