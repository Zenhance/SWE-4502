package unittesting;

import Class.Commands.CreateIssueCommand;
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
        List<Issue>issues= new ArrayList<>();
        issueRepository = new IssueRepository(issues);
        issue = new Issue( "Bug fixed", "abcd", Priority.Low);
        createIssueCommand = new CreateIssueCommand(issueRepository, issue);
    }

    @Test
    void CreateIssue_ShouldAddIssueToRepository() {
        createIssueCommand.Execute();
        Assertions.assertTrue(issueRepository.issues.contains(issue), "Class.Issue should be added to the repository");
        Assertions.assertEquals(1, issueRepository.issues.size(), "Repository should have one issue");
    }

    //undo check
    @Test
    void UndoCommand_ShouldRevertLastAction(){
        createIssueCommand.Undo();
        Assertions.assertFalse(issueRepository.issues.contains(issue), "Class.Issue should be removed to the repository");
        Assertions.assertEquals(0, issueRepository.issues.size(), "Repository should have one issue");
    }
}