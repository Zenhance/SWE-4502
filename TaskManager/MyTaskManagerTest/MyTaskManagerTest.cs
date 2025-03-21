using MyTaskManager;

namespace MyTaskManagerTest
{
    public class MyTaskManagerTest
    {
        [Fact]
        public void CreateIssue_ShouldAddIssueToRepository()
        {
           

            var issueRepository = new IssueRepository();
            var createCommand = new CreateIssueCommand(issueRepository, "Test Issue", "This is a test issue", Priority.Medium);
            createCommand.Execute();
            var retrievedIssue = issueRepository.GetIssue(createCommand.issue.Id);


            Assert.NotNull(retrievedIssue);
            Assert.Equal("Test Issue", retrievedIssue.Title);
            Assert.Equal("This is a test issue", retrievedIssue.Description);
            Assert.Equal(Priority.Medium, retrievedIssue.Priority);
            Assert.Equal(Status.Open, retrievedIssue.Status);
        }
    }
}