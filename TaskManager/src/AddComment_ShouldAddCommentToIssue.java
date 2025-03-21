import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AddComment_ShouldAddCommentToIssue {
    public User user = new User("Adid");
    public Issue issue = new Issue("101","Issue 1" , PRIORITY.High, STATUS.Open, user);
    public Comment comment = new Comment("C1", "Comment1",user);

    @Test
    void addCommentTest() {
        comment = issue.addComment(comment);
        Assert.assertEquals("C1", comment.getId());
    }

    @Test
    void addCommentTest2() {
        comment = issue.addComment(comment);
        Assert.assertEquals("Comment1", comment.getContent());
    }

    @Test
    void addCommentTest3() {
        comment = issue.addComment(comment);
        Assert.assertEquals(user, comment.getAuthor());
    }
}