package issues;

import org.junit.jupiter.api.Test;
import user.User;

import static org.junit.jupiter.api.Assertions.*;

class IssueRepositoryTest {

    @Test
    void createIssue() {
        User user= new User(23,"navid");
        Issue issue=user.createIssue("hello","world");
        assertEquals(user.issueRepository.isEmpty(),false);
        assertEquals(issue.status, Issue.Status.InProgress);

    }


}