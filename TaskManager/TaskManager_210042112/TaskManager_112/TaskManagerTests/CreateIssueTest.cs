using TaskManager_112;

namespace TaskManagerTests
{
    public class CreateIssueTest
    {
        [Fact]
        public void CreateIssue_ShouldAddIssueToRepository()
        {
            var repo = new IssueRepository();
            var issue = IssueFactory.CreateIssue(1, "Trying", "Commiting is hard", Priority.Medium);
            var createIssueCommand = new CreateIssueCommand(repo, issue);
            var invoker = new CommandInvoker();

            // Act
            invoker.ExecuteCommand(createIssueCommand);

            // Assert
            var retrievedIssue = repo.GetIssue(1);
            Assert.NotNull(retrievedIssue);
            Assert.Equal("Trying", retrievedIssue.Title);
            Assert.Equal(Priority.Medium, retrievedIssue.Priority);
            Assert.Equal(Status.Open, retrievedIssue.Status);
        }
    }
}