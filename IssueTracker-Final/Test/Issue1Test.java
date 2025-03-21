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

        IssueRepository repository = new IssueRepository();
Issue issue = new Issue("1", "Test Issue", "This is a test issue", Priority.Medium, Status.Open, LocalDateTime.now(), LocalDateTime.now(), "Test User", new ArrayList<>(), Arrays.asList("test", "issue"));


        CreateIssue createIssue = new CreateIssue(repository, issue);

        createIssue.execute();

        assertEquals(1, repository.getIssues().size());






    }

    @Test

    public void AddComment_ShouldAddCommentToIssue() {

    }


    @Test
    public void ChangeStatus_ShouldUpdateIssueStatus() {


    }














}








