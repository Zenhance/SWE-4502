import org.junit.jupiter.api.Test;

public class ChangeIssueStatusTest {
    @Test
    void changeStatus_ShouldUpdateIssueStatus() {
        repository.addIssue(testIssue);
        testIssue.status = Issue.Status.IN_PROGRESS;

        assertEquals(Issue.Status.IN_PROGRESS, repository.getIssue(testIssue.id).status);
    }

}
