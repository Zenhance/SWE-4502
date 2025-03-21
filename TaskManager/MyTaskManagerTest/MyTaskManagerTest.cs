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

            var addCommentToIssueCommand = new AddCommentCommand(issueRepository, retrievedIssue.Id, "Test comment", "Test author");
            addCommentToIssueCommand.Execute();

            Assert.Single(retrievedIssue.Comments);
            Assert.Equal("Test comment", retrievedIssue.Comments[0].Content);
            Assert.Equal("Test author", retrievedIssue.Comments[0].Author);
        }

        [Fact]
        public void Issue_Clone_ShouldCreateCompleteDeepCopy()
        {
            var issueRepository = new IssueRepository();
            var createCommand = new CreateIssueCommand(issueRepository, "Test Issue", "This is a test issue", Priority.Medium);
            createCommand.Execute();
            var retrievedIssue = issueRepository.GetIssue(createCommand.issue.Id);

            var addCommentToIssueCommand = new AddCommentCommand(issueRepository, retrievedIssue.Id, "Test comment", "Test author");
            addCommentToIssueCommand.Execute();

            var originalIssue = retrievedIssue;
            var clonedIssue = (Issue)originalIssue.Clone();

            originalIssue.Title = "Modified Title";
            originalIssue.Comments[0].Content = "Modified Content";

            Assert.Equal("Test Issue", clonedIssue.Title);
            Assert.Equal("Test comment", clonedIssue.Comments[0].Content);
            Assert.NotEqual(originalIssue.Title, clonedIssue.Title);
            Assert.NotEqual(originalIssue.Comments[0].Content, clonedIssue.Comments[0].Content);
        }

        [Fact]
        public void ChangeStatus_ShouldUpdateIssueStatus()
        {
            var issueRepository = new IssueRepository();
            var createCommand = new CreateIssueCommand(issueRepository, "Test Issue", "This is a test issue", Priority.Medium);
            createCommand.Execute();
            var retrievedIssue = issueRepository.GetIssue(createCommand.issue.Id);

            var changeIssueStatusCommand = new ChangeIssueStatusCommand(issueRepository, retrievedIssue.Id, Status.InProgress);
            changeIssueStatusCommand.Execute();
           
            Assert.Equal(Status.InProgress, retrievedIssue.Status);
        }

        [Fact]
        public void UndoCommand_ShouldRevertLastAction()
        {
            var issueRepository = new IssueRepository();
            var createCommand = new CreateIssueCommand(issueRepository, "Test Issue", "This is a test issue", Priority.Medium);
            var commandInvoker = new CommandInvoker();
            commandInvoker.ExecuteCommand(createCommand);

            var retrievedIssue = issueRepository.GetIssue(createCommand.issue.Id);

            var changeIssueStatusCommand = new ChangeIssueStatusCommand(issueRepository, retrievedIssue.Id, Status.InProgress);
            commandInvoker.ExecuteCommand(changeIssueStatusCommand);

            commandInvoker.Undo();

            Assert.Equal(Status.Open, retrievedIssue.Status);
        }

        [Fact]
        public void RedoCommand_ShouldReapplyUndoneAction()
        {
            var issueRepository = new IssueRepository();
            var createCommand = new CreateIssueCommand(issueRepository, "Test Issue", "This is a test issue", Priority.Medium);
            var commandInvoker = new CommandInvoker();
            commandInvoker.ExecuteCommand(createCommand);

            var retrievedIssue = issueRepository.GetIssue(createCommand.issue.Id);

            var changeIssueStatusCommand = new ChangeIssueStatusCommand(issueRepository, retrievedIssue.Id, Status.InProgress);
            commandInvoker.ExecuteCommand(changeIssueStatusCommand);

            commandInvoker.Undo();
            commandInvoker.Redo();

            Assert.Equal(Status.InProgress, retrievedIssue.Status);
        }

        [Fact]
        public void StatisticsCollector_ShouldTrackCommandCounts()
        {
            var issueRepository = new IssueRepository();
            var createCommand = new CreateIssueCommand(issueRepository, "Test Issue", "This is a test issue", Priority.Medium);
            var commandInvoker = new CommandInvoker();
            commandInvoker.ExecuteCommand(createCommand);

            var createCommand2 = new CreateIssueCommand(issueRepository, "Test Issue 2", "This is a test issue 2", Priority.Low);
            commandInvoker.ExecuteCommand(createCommand2);

            
            Assert.Equal(2, commandInvoker.GetCommandStats(CommandType.Create));
        }

        [Fact]
        public void Logger_ShouldStoreCommandHistoryLogs()
        {
            var issueRepository = new IssueRepository();
            var createCommand = new CreateIssueCommand(issueRepository, "Test Issue", "This is a test issue", Priority.Medium);
            var commandInvoker = new CommandInvoker();
            commandInvoker.ExecuteCommand(createCommand);

            var createCommand2 = new CreateIssueCommand(issueRepository, "Test Issue 2", "This is a test issue 2", Priority.Low);
            commandInvoker.ExecuteCommand(createCommand2);

            var commandLogs = commandInvoker.GetCommandLogs();
            Assert.Equal(2, commandLogs.Count());
        }
    }
}