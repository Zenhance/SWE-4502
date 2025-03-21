package tests;
import commands.AddCommentToIssueCommand;
import commands.ChangeIssueStatusCommand;
import enums.Status;
import models.Comment;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import commands.CreateIssueCommand;
import enums.Priority;
import models.Issue;
import models.IssueRepository;

class taskManagerTest {
    @Test
    void testCreateIssue_ShouldAddIssueToRepository() {
        IssueRepository repo = new IssueRepository();
        Issue issue = new Issue("Issue Title", "Issue Description", Priority.LOW);
        CreateIssueCommand createIssue = new CreateIssueCommand(repo,issue,"Command Desc", "Command type");

        createIssue.execute();
        assertNotNull(repo.getIssue(issue.getId()));
        assertNotNull(repo.getAllIssue());
    }

    @Test
    void AddComment_ShouldAddCommentToIssue() {

        IssueRepository repo2 = new IssueRepository();
        Issue issue2 = new Issue("Issue Title", "Issue Description", Priority.LOW);
        CreateIssueCommand createIssue2 = new CreateIssueCommand(repo2, issue2,"Command Desc", "Command type");


        Comment cmnt = new Comment("Mainul", "Good job");
        AddCommentToIssueCommand addComment = new AddCommentToIssueCommand(repo2, issue2.getId(),cmnt,"This is comment", "Comment");


        createIssue2.execute();
        addComment.execute();
        assertNotNull(issue2.getComments());

    }

    @Test
    void ChangeStatus_ShouldUpdateIssueStatus(){

        IssueRepository repo = new IssueRepository();
        Issue issue = new Issue("Issue Title", "Issue Description", Priority.LOW);
        CreateIssueCommand createIssue = new CreateIssueCommand(repo,issue,"Command Desc", "Command type");

        ChangeIssueStatusCommand changeStatus = new ChangeIssueStatusCommand(repo, issue.getId(), Status.RESOLVED,"This is resolved", "Issue status change");

        createIssue.execute();


        changeStatus.execute();

        assertEquals(issue.getStatus(), Status.RESOLVED);
    }

}