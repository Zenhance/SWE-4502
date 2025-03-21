import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;

class IssueTest {

    IssueRepository issues= new IssueRepository();
    Issue issue1= new Issue("Lab Final", "Task Manager", Priority.Critical);


    @Test
    void CreateIssue_ShouldAddIssueToRepository(){
        issues.addIssue(issue1);
        assertEquals(issues.getIssue(issue1), ("Title: "+ issue1.getTitle()+" Description: "+issue1.getDescription()+" Priority: "+issue1.getPriority()));
    }

    @Test
    void AddComment_ShouldAddCommentToIssue(){
        User user1= new User();
        Comment firstComment= new Comment("First Comment", user1);
        issue1.addComment(firstComment);
        assertTrue(issue1.getComment(firstComment));
    }

    @Test
    void ChangeStatus_ShouldUpdateIssueStatus(){
        String s1= issue1.getStatus();
        issue1.changeStatus(Status.InProgress);
        String s2= issue1.getStatus();
        assertNotEquals(s1, s2);
    }

    @Test
    void UndoCommand_ShouldRevertLastAction(){
        Application app= new Application();
        Editor editor= new Editor();

        editor.insertText("Hi There");
        String s1= editor.getText();
        app.setUndoCommand();
        String s2= editor.getText();
        assertNotEquals(s1, s2);
    }

    @Test
    void Issue_Clone_ShouldCreateCompleteDeepCopy(){
        Issue issue2= new Issue("Lab 1", "Hi", Priority.Low);
        Issue issue3= issue2.clone();
        String s1= issue2.getDetails();
        String s2= issue3.getDetails();
        assertEquals(s1, s2);
    }

}