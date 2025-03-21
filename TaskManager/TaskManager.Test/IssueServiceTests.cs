﻿using Xunit;
using TaskManager;
using TaskManager.Domain;

namespace TaskManager.Test;

public class IssueServiceTests
{
    [Fact()]
    public void AddComment_ShouldAddCommentToIssue()
    {
        var issue = new Issue
        {
            Title = "first issue",
            Description = "lorem ispum..",
            Priority = IssuePriority.Low
        };

        var service = new IssueService();
        issue = service.CreateIssue(issue);
        var comment = new Comment
        {
            Content = "a comment",
            Author = "Alice"
        };
        var result = service.AddComment(issue.Id, comment);

        Assert.Equal(result.Id, comment.Id);
        Assert.Equal(result.Content, comment.Content);
        Assert.Equal(result.Author, comment.Author);
    }

    [Fact()]
    public void ChangeStatus_ShouldUpdateIssueStatus()
    {
        var issue = new Issue
        {
            Title = "another issue",
            Description = "lorem ispum..",
            Priority = IssuePriority.Low
        };

        var service = new IssueService();
        issue = service.CreateIssue(issue);
        issue = service.UpdateIssueStatus(issue.Id, IssueStatus.InProgress);

        Assert.Equal(issue.Status, IssueStatus.InProgress);
    }
}