import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class IssueRepositoryTest {
    @Test
    public void TaskManagerTest()
    {
        //Test 1

        IssueRepository repository = new IssueRepository();
        Issue issue = new Issue("LabFinal", "Final_Lab_for_Java", "Hamim", Issue.Priority.Low);
        repository.addIssue(issue);
        Issue searchedIssue = repository.getIssue(issue.getId());

        assertTrue(searchedIssue.getId() == issue.getId());
        assertTrue(searchedIssue.getTitle().equals("LabFinal"));
        assertTrue(searchedIssue.getDescription().equals("Final_Lab_for_Java"));
        assertTrue(searchedIssue.getStatus().toString().equals("Open"));
        assertTrue(searchedIssue.getPriority().toString().equals("Low"));

//        Test 2

        Comment comment = new Comment( "This is a comment");
        searchedIssue.addComment(comment);
        assertTrue(searchedIssue.getCommentById(comment.getId()).content.equals("This is a comment"));

//        Test 3

        searchedIssue.setStatus(Issue.Status.Closed);
        assertTrue(searchedIssue.getStatus().toString().equals("Closed"));


        // Test 4


    }
}