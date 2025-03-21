package Lab_final_210042166.Unit_Test.Add_Comment_Test;
import Lab_final_210042166.Task_Management_System.Add_Comment.AddCommentCommand;
import Lab_final_210042166.Task_Management_System.Comment.Comment;
import Lab_final_210042166.Task_Management_System.Enum.Priority;
import Lab_final_210042166.Task_Management_System.Interface.Command;
import Lab_final_210042166.Task_Management_System.Issue.Issue;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
public class AddCommentTest {
    @Test
    public void AddComment_ShouldAddCommentToIssue() {
        Issue issue = new Issue("1", "Test Issue", "Adding Comment", Priority.MEDIUM, "User1");
        Comment comment = new Comment("Hello", "Test Comment", "User2");
        Command addCommentCommand = new AddCommentCommand(issue, comment);

        addCommentCommand.execute();
        assertEquals(1, issue.getComments().size());
        assertEquals("Test Comment", issue.getComments().get(0).getContent());
    }


}
