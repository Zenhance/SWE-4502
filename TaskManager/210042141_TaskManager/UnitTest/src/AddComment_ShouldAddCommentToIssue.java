import org.junit.Test;

import java.util.Date;
import java.lang.NullPointerException;

import static org.junit.Assert.assertTrue;

public class AddComment_ShouldAddCommentToIssue {

    @Test
    public void AddComment_ShouldAddCommentToIssueTest() {
        IssueRepository repository = new IssueRepository();
        Issue issue = new Issue(1, "Issue 1", "Description", "High", "Open", new Date(), new Date(), "FirstUser", null, null);
        repository.addIssue(issue);

        Comment comment = new Comment(1, "Comment", "Author", new Date());
        issue.getComments().add(comment);

        assertTrue(issue.getComments().contains(comment));
    }
}
