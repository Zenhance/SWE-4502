package unittesting;

import Predefinedvalues.Priority;
import Predefinedvalues.Status;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import Class.*;

import static org.junit.jupiter.api.Assertions.*;

class UpdateCommentCommandTest {
    private IssueRepository issueRepository;
    private Issue issue;
    private UpdateCommentCommand updateCommentCommand;

    @BeforeEach
    void setUp() {
        List<String> tags = new ArrayList<>();
        List<Issue> issues = new ArrayList<>();
        List<Comment> comments = new ArrayList<>();
        
        Comment initialComment = new Comment(1834, "New Comment", "tasnim", "25/12/14");
        comments.add(initialComment);
        
        issueRepository = new IssueRepository(issues);
        issue = new Issue(1, "Bug fixed", "abcd", Priority.Low, Status.Open, "25/3/2025", "25/3/2025", "tasnim", tags, comments);
        updateCommentCommand = new UpdateCommentCommand(issueRepository, issue, initialComment);
    }



    @Test
    void AddComment_ShouldAddCommentToIssue() {
        Comment newComment = new Comment(2000, "Test comment content", "testUser", "21/03/2025");
        UpdateCommentCommand addCommentCommand = new UpdateCommentCommand(issueRepository, issue, newComment);


        addCommentCommand.Execute();


        assertTrue(issue.comments.contains(newComment), "Comment should be added to the issue");
        assertEquals(2, issue.comments.size(), "Issue should have two comments");
        assertEquals("Test comment content", issue.comments.get(1).getContent(), "Comment content should match");
        assertEquals("testUser", issue.comments.get(1).getAuthor(), "Comment author should match");
    }
}