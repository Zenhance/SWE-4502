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

        [Fact]
        public void AddComment_ShouldAddCommentToIssue()
        {
            var issueRepository = new IssueRepository();
            var createCommand = new CreateIssueCommand(issueRepository, "Test Issue", "This is a test issue", Priority.Medium);
            createCommand.Execute();
            var retrievedIssue = issueRepository.GetIssue(createCommand.issue.Id);

            var addCommentToIssueCommand = new AddCommentCommand(issueRepository, createCommand.issue.Id, "Test comment", "Test author");
            addCommentToIssueCommand.Execute();

            Assert.Single(retrievedIssue.Comments);
            Assert.Equal("Test comment", retrievedIssue.Comments[0].Content);
            Assert.Equal("Test author", retrievedIssue.Comments[0].Author);
        }
    }
}