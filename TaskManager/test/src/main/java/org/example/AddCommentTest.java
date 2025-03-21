package org.example;

import command.AddCommentCommand;
import command.CommandManager;
import model.Comment;
import model.Issue;
import model.Priority;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import repository.IssueRepository;

import static org.junit.jupiter.api.Assertions.*;

public class AddCommentTest {
    private IssueRepository repository;
    private CommandManager commandManager;
    private Issue testIssue;
    
    @BeforeEach
    public void setUp() {
        // reset repo
        repository = IssueRepository.getInstance();
        // clear issues
        for (String id : repository.getAllIssues().keySet()) {
            repository.removeIssue(id);
        }
        
        commandManager = CommandManager.getInstance();
        
        // create test issue
        testIssue = new Issue("Test Issue", "This is a test issue", Priority.Medium);
        repository.addIssue(testIssue);
    }
    
    @Test
    public void AddComment_ShouldAddCommentToIssue() {
        // add comment to issue
        Comment comment = new Comment("This is a test comment", "Test User");
        AddCommentCommand command = new AddCommentCommand(testIssue, comment);
        commandManager.executeCommand(command);
        
        // verify comment (content and author)
        Issue retrievedIssue = repository.getIssue(testIssue.getId());
        assertEquals(1, retrievedIssue.getComments().size());
        Comment retrievedComment = retrievedIssue.getComments().get(0);
        assertEquals("This is a test comment", retrievedComment.getContent());
        assertEquals("Test User", retrievedComment.getAuthor());
    }
}