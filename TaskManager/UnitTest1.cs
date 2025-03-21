using Xunit;

public class TestCreateIssue
{
    [Fact]
    public void CreateIssue_ShouldAddIssueToRepository()
    {
        var repo = new IssueRepository();
        var issue = new Issue(1, "Bug in UI", "Fix button", Priority.High);
        var command = new CreateIssueCommand(repo, issue);

        command.Execute();
        Assert.NotNull(repo.GetIssue(1));

        command.Undo();
        Assert.Null(repo.GetIssue(1));
    }
}

public class AddComment_ShouldAddCommentToIssue
{
    [Fact]
    public void AddComment_ShouldAddCommentToIssue()
    {

    }
}