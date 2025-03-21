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

}