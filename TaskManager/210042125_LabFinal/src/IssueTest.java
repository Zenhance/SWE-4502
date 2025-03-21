import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;

class IssueTest {

    IssueRepository issues= new IssueRepository();


    @Test
    void CreateIssue_ShouldAddIssueToRepository(){
        Issue issue1= new Issue("Lab Final", "Task Manager", Priority.Critical);
        issues.addIssue(issue1);
        assertEquals(issues.getIssue(issue1), ("Title: "+ issue1.getTitle()+" Description: "+issue1.getDescription()+" Priority: "+issue1.getPriority()));
    }

    @Test
    void AddComment_ShouldAddCommentToIssue(){
        Issue issue1= new Issue("Lab Final", "Task Manager", Priority.Critical);
        User user1= new User();
        Comment firstComment= new Comment("First Comment", user1);
        issue1.addComment(firstComment);
        assertTrue(issue1.getComment(firstComment));
    }


}