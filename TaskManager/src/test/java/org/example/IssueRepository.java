package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IssueRepository {
    @Test
    void CreateIssue_ShouldAddIssueToRepository(){
//        Act: Create a new issue with title, description, and priority
//        Assert: Verify that the issue exists in repository with correct properties and default status
        Issue issue= new Issue();
        issue.createIssue();
        assertTrue(issue.toString().contains("Issue Created"));
    }

    @Test
    void AddComment_ShouldAddCommentToIssue(){

    }
}