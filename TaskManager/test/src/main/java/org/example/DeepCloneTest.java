package org.example;

import model.Comment;
import model.Issue;
import model.Priority;
import model.Status;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

public class DeepCloneTest {
    
    @Test
    public void Issue_Clone_ShouldCreateCompleteDeepCopy() {
        // Act: Create and clone an issue with all properties set
        Issue originalIssue = new Issue("Test Issue", "This is a test issue", Priority.High);
        originalIssue.setStatus(Status.InProgress);
        originalIssue.setAssignedTo("Test User");
        originalIssue.addTag("bug");
        originalIssue.addTag("critical");
        
        Comment comment1 = new Comment("First comment", "User 1");
        Comment comment2 = new Comment("Second comment", "User 2");
        originalIssue.addComment(comment1);
        originalIssue.addComment(comment2);
        
        // Clone the issue
        Issue clonedIssue = originalIssue.clone();
        
        // Assert: Verify clone is independent copy with identical values
        // Check basic properties
        assertEquals(originalIssue.getId(), clonedIssue.getId());
        assertEquals(originalIssue.getTitle(), clonedIssue.getTitle());
        assertEquals(originalIssue.getDescription(), clonedIssue.getDescription());
        assertEquals(originalIssue.getPriority(), clonedIssue.getPriority());
        assertEquals(originalIssue.getStatus(), clonedIssue.getStatus());
        assertEquals(originalIssue.getAssignedTo(), clonedIssue.getAssignedTo());
        
        // Check dates
        assertEquals(originalIssue.getCreationDate(), clonedIssue.getCreationDate());
        assertEquals(originalIssue.getLastModifiedDate(), clonedIssue.getLastModifiedDate());
        
        // Check tags
        assertEquals(originalIssue.getTags().size(), clonedIssue.getTags().size());
        assertTrue(clonedIssue.getTags().contains("bug"));
        assertTrue(clonedIssue.getTags().contains("critical"));
        
        // Check comments
        assertEquals(originalIssue.getComments().size(), clonedIssue.getComments().size());
        assertEquals(originalIssue.getComments().get(0).getContent(), clonedIssue.getComments().get(0).getContent());
        assertEquals(originalIssue.getComments().get(1).getContent(), clonedIssue.getComments().get(1).getContent());
        
        // Verify deep copy by modifying the clone and checking the original remains unchanged
        clonedIssue.setTitle("Modified Title");
        clonedIssue.addTag("new-tag");
        clonedIssue.addComment(new Comment("New comment", "User 3"));
        
        assertNotEquals(originalIssue.getTitle(), clonedIssue.getTitle());
        assertNotEquals(originalIssue.getTags().size(), clonedIssue.getTags().size());
        assertNotEquals(originalIssue.getComments().size(), clonedIssue.getComments().size());
    }
}