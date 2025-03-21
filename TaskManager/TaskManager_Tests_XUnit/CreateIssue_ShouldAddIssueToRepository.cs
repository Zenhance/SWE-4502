using TaskManager;
namespace TaskManager_Tests_XUnit
{
    public class AddComment_ShouldAddCommentToIssue
    {
        [Fact]
        public void CreateIssue_Test_Method()
        {
            IssueRepository repo = new IssueRepository();
            Issue issue = new Issue(1, "Test Issue", "Test Description", Priority.Medium);
            CreateIssueCommand createIssueCommand = new CreateIssueCommand(repo, issue);
            CommandManager commandManager = new CommandManager();

            commandManager.ExecuteCommand(createIssueCommand);


            var retrievedIssue = repo.GetIssue(1);

            Assert.Equal(1, retrievedIssue.Id);
            Assert.Equal("Test Issue", retrievedIssue.Title);

        }
    }
}