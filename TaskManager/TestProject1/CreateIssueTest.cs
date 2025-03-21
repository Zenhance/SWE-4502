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
    [Fact]
    public void AddComment_ShouldAddCommentToIssue()
    {
        var repository = new IssueRepository();
        var issue = new Issue { Title = "Test Issue", Description = "Test Description", Priority = Priority.Medium };
        repository.AddIssue(issue);
        var command= new Comment{ Content="Test Comment", Author="Test Author" };
        
        issue.Comments.Add(command);
        var retrievedIssue = repository.GetIssue(issue.Id);
        Assert.Single(retrievedIssue.Comments);
        Assert.Equal(command.Content, retrievedIssue.Comments[0].Content);
        Assert.Equal(command.Author, retrievedIssue.Comments[0].Author);
    }

    [Fact]
    public void ChangeStatus_ShouldUpdateIssueStatus()
    {
        var repository = new IssueRepository();
        var issue = new Issue { Title = "Test Issue", Description = "Test Description", Priority = Priority.Medium };
        repository.AddIssue(issue);
        var command =new ChangeStatusCommand(repository, issue.Id, Status.InProgress);
        command.Execute();
        var retrievedIssue = repository.GetIssue(issue.Id);
        Assert.Equal(issue.Status, retrievedIssue.Status);
    }
    [Fact]
    public void UndoCommand_ShouldRevertLastAction()
    {
        var repository = new IssueRepository();
        var issue = new Issue { Title = "Test Issue", Description = "Test Description", Priority = Priority.Medium };
        var commandManager = new CommandManager();
        var createCommand = new CreateIssueCommand(repository, issue);
        commandManager.ExecuteCommand(createCommand);
        commandManager.Undo();
        var retrievedIssue = repository.GetIssue(issue.Id);
        Assert.Null(retrievedIssue); 
    }

    [Fact]
    public void RedoCommand_ShouldReapplyUndoneAction()
    {
        var repository = new IssueRepository();
        var issue = new Issue { Title = "Test Issue", Description = "Test Description", Priority = Priority.Medium };
        var commandManager = new CommandManager();
        var createCommand = new CreateIssueCommand(repository, issue);
        commandManager.ExecuteCommand(createCommand);
        commandManager.Undo();
        commandManager.Redo();
        var retrievedIssue = repository.GetIssue(issue.Id);
        Assert.NotNull(retrievedIssue); 
    }
}