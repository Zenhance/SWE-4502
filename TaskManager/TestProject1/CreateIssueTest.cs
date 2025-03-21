using Xunit;
using TaskManager.Models;
using TaskManager.Repositories;
using TaskManager.Commands;

namespace TestProject1;

public class CreateIssueTest
{
    [Fact]
    public void CreateIssue_ShouldAddIssueToRepository()
    {
        var repository = new IssueRepository();
        var  issue = new Issue { Title = "Test Issue", Description = "Test Description", Priority = Priority.Medium };
        var command = new CreateIssueCommand( repository, issue);
        command.Execute();
        
        var retrievedIssue= repository.GetIssue(issue.Id);
        Assert.NotNull(retrievedIssue);
        Assert.Equal(issue.Title, retrievedIssue.Title);
        Assert.Equal(issue.Description, retrievedIssue.Description);
        Assert.Equal(Priority.Medium, retrievedIssue.Priority);
        Assert.Equal(Status.Open, retrievedIssue.Status);
    }
}