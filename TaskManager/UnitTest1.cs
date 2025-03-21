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
public class TestAddComment
{
    [Fact]
    public void AddComment_ShouldAddCommentToIssue()
    {
        var repo = new IssueRepository();
        var issue = new Issue(1, "Bug in UI", "Fix button", Priority.Medium);
        repo.AddIssue(issue);

        var comment = new Comment(1, "This bug affects login page", "Iqra");
        issue.AddComment(comment);

        Assert.Single(issue.Comments);
        Assert.Equal("This bug affects login page", issue.Comments[0].Content);
        Assert.Equal("Iqra", issue.Comments[0].Author);
    }
}



public class TestChangeStatus
{
    [Fact]
    public void ChangeStatus_ShouldUpdateIssueStatus()
    {
        var repo = new IssueRepository();
        var issue = new Issue(1, "Backend Error", "Fix API timeout", Priority.Critical);
        repo.AddIssue(issue);

        issue.IssueStatus = Status.Resolved;

        Assert.Equal(Status.Resolved, issue.IssueStatus);
    }
}

using Xunit;
using Moq;

public class TestObserver
{
    [Fact]
    public void Observer_ShouldReceiveNotifications()
    {
        var notificationService = new NotificationService();
        var mockObserver = new Mock<IObserver>();

        notificationService.Subscribe(mockObserver.Object);
        notificationService.Notify("Issue status changed");

        mockObserver.Verify(o => o.Update("Issue status changed"), Times.Once());
    }
}

public class TestStatistics
{
    [Fact]
    public void StatisticsCollector_ShouldTrackCommandCounts()
    {
        var statsCollector = new StatisticsCollector();

        statsCollector.Track("CreateIssue");
        statsCollector.Track("UpdateIssue");
        statsCollector.Track("CreateIssue");

        Assert.Equal(2, statsCollector.GetStatistics()["CreateIssue"]);
        Assert.Equal(1, statsCollector.GetStatistics()["UpdateIssue"]);
    }
}

