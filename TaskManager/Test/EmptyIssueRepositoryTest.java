package test;

import models.IssueRepository;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class EmptyIssueRepositoryTest {
    @Test
    public void EmptyIssueRepository_ShouldReturnNull() {
        IssueRepository repository = new IssueRepository();
        assertNull(repository.getIssue(99));
}
}