using TaskManager.Domain;

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


}