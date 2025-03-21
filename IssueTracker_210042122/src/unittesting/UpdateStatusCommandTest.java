package unittesting;

import Class.Commands.UpdateCommentCommand;
import Class.Commands.UpdateStatusCommand;
import Predefinedvalues.Priority;
import Predefinedvalues.Status;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import Class.*;

import static org.junit.jupiter.api.Assertions.*;

class UpdateStatusCommandTest {
    private IssueRepository issueRepository;
    private Issue issue;
    private UpdateStatusCommand updateStatusCommand;

    @BeforeEach
    void setUp() {
        List<String> tags = new ArrayList<>();
        List<Issue> issues = new ArrayList<>();
        List<Comment> comments = new ArrayList<>();


        issueRepository = new IssueRepository(issues);
        issue = new Issue(1, "Bug fixed", "abcd", Priority.Low, Status.Open, "25/3/2025", "25/3/2025", "tasnim", tags, comments);

    }



    @Test
    void AddComment_ShouldAddCommentToIssue() {
        updateStatusCommand = new UpdateStatusCommand(issueRepository, issue, Status.Closed);
        updateStatusCommand.Execute();

        Status status=issue.getStatus();

        assertEquals(Status.Closed, status, "Comment content should match");
        assertEquals("tasnim", issue.getAuthor(), "Comment author should match");
    }
}