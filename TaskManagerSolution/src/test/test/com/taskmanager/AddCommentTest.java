package test.test.com.taskmanager;

import com.taskmanager.model.Comment;
import com.taskmanager.model.Issue;
import com.taskmanager.repository.IssueRepository;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AddCommentTest {

    @Test
    public void AddComment_ShouldAddCommentToIssue() {
        IssueRepository repository = new IssueRepository();
        Issue issue = new Issue();
        issue.setId("1");
        repository.addIssue(issue);

        Comment comment = new Comment();
        comment.setId("C1");
        comment.setContent("This is a comment");
        comment.setAuthor("John Doe");

        issue.getComments().add(comment);

        Issue retrievedIssue = repository.getIssue("1");
        assertEquals(1, retrievedIssue.getComments().size());
        assertEquals("This is a comment", retrievedIssue.getComments().get(0).getContent());
        assertEquals("John Doe", retrievedIssue.getComments().get(0).getAuthor());
    }
}