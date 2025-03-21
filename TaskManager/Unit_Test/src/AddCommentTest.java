import org.junit.jupiter.api.Test;

public class AddCommentTest {

    @Test
    void addComment_ShouldAddCommentToIssue() {
        repository.addIssue(testIssue);
        Comment comment = new Comment("This is urgent!", "John");

        testIssue.addComment(comment);

        assertEquals(1, testIssue.comments.size());
        assertEquals("This is urgent!", testIssue.comments.get(0).content);
    }
}
