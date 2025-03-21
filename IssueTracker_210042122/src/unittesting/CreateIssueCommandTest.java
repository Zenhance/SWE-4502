package unittesting;

import Predefinedvalues.Priority;
import Predefinedvalues.Status;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import Class.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class CreateIssueCommandTest {
    private IssueRepository issueRepository;

    private Issue issue;
    private CreateIssueCommand createIssueCommand;

    @BeforeEach
    void setUp() {
        List<Comment> comments = new ArrayList<>();
        List<String> tags = new ArrayList<>();
        List<Issue>issues= new ArrayList<>();
        issueRepository = new IssueRepository(issues);
        issue = new Issue(1, "Bug fixed", "abcd", Priority.Low, Status.Open, "25/3/2025", "25/3/2025", "tasnim", tags, comments);
        createIssueCommand = new CreateIssueCommand(issueRepository, issue);
    }

    @Test
    void testCreateIssue() {
        createIssueCommand.Execute();
        Assertions.assertTrue(issueRepository.issues.contains(issue), "Class.Issue should be added to the repository");
        Assertions.assertEquals(1, issueRepository.issues.size(), "Repository should have one issue");
    }
}