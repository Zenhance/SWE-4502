package issues;

import comment.Comment;
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

    @Test
    void createComment() {
        User user= new User(23,"navid");
        Issue issue=user.createIssue("hello","world");
        Comment comment= user.createComment(123,"hello",issue.id, user.id);
        assertEquals(issue.commentHashMap.get(comment.id),comment);



    }




}