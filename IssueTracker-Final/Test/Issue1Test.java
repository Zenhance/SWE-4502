import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class Issue1Test {


    @Test
    public void CreateIssue_ShouldAddIssueToRepository() {

        IssueRepository issueRepository = new IssueRepository();
        Issue issue = new Issue("1", "Title", "Description", Priority.Low, Status.Open, LocalDateTime.now(), LocalDateTime.now(), "AssignedTo", new ArrayList<>(), new ArrayList<>());


        issueRepository.addIssue(issue);

        assertEquals(issue, issueRepository.getIssue("1"));
    }

    @Test

    public void AddComment_ShouldAddCommentToIssue() {

        IssueRepository issueRepository = new IssueRepository();
        Issue issue = new Issue("1", "Title", "Description", Priority.Low, Status.Open, LocalDateTime.now(), LocalDateTime.now(), "AssignedTo", new ArrayList<>(), new ArrayList<>());
        Comment comment = new Comment(1, "Content", "Author", LocalDateTime.now());

        issueRepository.addIssue(issue);
        issueRepository.AddComment("1", comment);

        assertEquals(comment, issueRepository.getIssue("1").comments.get(0));
    }


    @Test
    public void ChangeStatus_ShouldUpdateIssueStatus() {

        IssueRepository issueRepository = new IssueRepository();
        Issue issue = new Issue("1", "Title", "Description", Priority.Low, Status.Open, LocalDateTime.now(), LocalDateTime.now(), "AssignedTo", new ArrayList<>(), new ArrayList<>());

        issueRepository.addIssue(issue);
        issueRepository.ChangeIssueStatus("1", Status.Closed);

        assertEquals(Status.Closed, issueRepository.getIssue("1").status);
    }














}








