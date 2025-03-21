using TaskManager.Domain;
using TaskManager.Repositories;

namespace TaskManager.Test;

public class IssueRepositoryTests
{
    [Fact()]
    public void CreateIssue_ShouldAddIssueToRepository()
    {
        var issue = new Issue
        {
            Title = "first issue",
            Description = "lorem ispum..",
            Priority = IssuePriority.Low
        };

        var repo = new IssueRepository();
        repo.Create(issue);
        var result = repo.FindById(issue.Id);

        Assert.Equal(result.Id, issue.Id);
        Assert.Equal(result.Title, issue.Title);
        Assert.Equal(result.Description, issue.Description);
        Assert.Equal(result.Priority, issue.Priority);
    }
    

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
}