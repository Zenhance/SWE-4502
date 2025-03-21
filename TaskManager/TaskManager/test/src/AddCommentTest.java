import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AddCommentTest{
    @Test
    void testCommentAddition(){
        Issue issue=new Issue("AddComment","Comment Addition", Priority.Low);
        Comment comment=new Comment(1,"Good");
        TaskManager taskManager=new TaskManager();
        Command command=new CommentCommand(issue,comment);
        taskManager.setCommand(command);
        taskManager.execution();

        assertEquals("True",taskManager.getDone());
    }
}