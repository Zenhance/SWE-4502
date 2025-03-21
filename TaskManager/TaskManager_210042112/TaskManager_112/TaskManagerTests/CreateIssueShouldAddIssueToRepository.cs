using TaskManager_112;

namespace TaskManagerTests
{
    public class CreateIssueShouldAddIssueToRepository
    {
        [Fact]
        public void CreateIssue_ShouldAddIssueToRepository()
        {
            var repository = new IssueRepository();
            var issue = IssueFactory.CreateIssue(1, "First Issue", "Description", Priority.Medium);
            var createIssueCommand = new CreateIssueCommand(repository, issue);
            var invoker = new CommandInvoker();
            // Act
            invoker.ExecuteCommand(createIssueCommand);
            // Assert
            var retrievedIssue = repository.GetIssue(1);
            Assert.NotNull(retrievedIssue);
            Assert.Equal("First Issue", retrievedIssue.Title);
            Assert.Equal(Priority.Medium, retrievedIssue.Priority);
            Assert.Equal(Status.Open, retrievedIssue.Status);
        }
    }
}