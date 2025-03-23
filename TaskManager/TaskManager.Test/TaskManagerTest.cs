using TaskManager.Commands;
using TaskManager.Domain;
using TaskManager.Observers;
using TaskManager.Repository;
using TaskManager.Service;
using TaskManager.Subjects;
using Assert = Xunit.Assert;

namespace TaskManager.Test
{
    public class TaskManagerTest
    {
        [Fact]
        public void CreateIssue_ShouldAddIssueToRepository()
        {
            // Arrange
            var repository = new IssueRepository();
            var commandManager = new CommandManager();
            var service = new IssueService(repository, commandManager);

            // Act
            int issueId = service.CreateIssue("Test Issue", "Description", IssuePriority.Medium);

            // Assert
            var issue = service.GetIssue(issueId);
            Assert.NotNull(issue);
            Assert.Equal("Test Issue", issue.Title);
            Assert.Equal("Description", issue.Description);
            Assert.Equal(IssuePriority.Medium, issue.Priority);
            Assert.Equal(IssueStatus.Open, issue.Status);
        }

        [Fact]
        public void AddComment_ShouldAddCommentToIssue()
        {
            // Arrange
            var repository = new IssueRepository();
            var commandManager = new CommandManager();
            var service = new IssueService(repository, commandManager);
            int issueId = service.CreateIssue("Test Issue", "Description", IssuePriority.Medium);

            // Act
            service.AddComment(issueId, "Test comment", "TestUser");

            // Assert
            var issue = service.GetIssue(issueId);
            Assert.Single(issue.Comments);
            Assert.Equal("Test comment", issue.Comments.First().Content);
            Assert.Equal("TestUser", issue.Comments.First().Author);
        }

        [Fact]
        public void ChangeStatus_ShouldUpdateIssueStatus()
        {
            // Arrange
            var repository = new IssueRepository();
            var commandManager = new CommandManager();
            var service = new IssueService(repository, commandManager);
            int issueId = service.CreateIssue("Test Issue", "Description", IssuePriority.Medium);

            // Act
            service.ChangeStatus(issueId, IssueStatus.InProgress);

            // Assert
            var issue = service.GetIssue(issueId);
            Assert.Equal(IssueStatus.InProgress, issue.Status);
        }

        [Fact]
        public void UndoCommand_ShouldRevertLastAction()
        {
            // Arrange
            var repository = new IssueRepository();
            var commandManager = new CommandManager();
            var service = new IssueService(repository, commandManager);
            int issueId = service.CreateIssue("Test Issue", "Description", IssuePriority.Medium);
            service.ChangeStatus(issueId, IssueStatus.InProgress);

            // Act
            service.UndoLastCommand();

            // Assert
            var issue = service.GetIssue(issueId);
            Assert.Equal(IssueStatus.Open, issue.Status);
        }

        [Fact]
        public void RedoCommand_ShouldReapplyUndoneAction()
        {
            // Arrange
            var repository = new IssueRepository();
            var commandManager = new CommandManager();
            var service = new IssueService(repository, commandManager);
            int issueId = service.CreateIssue("Test Issue", "Description", IssuePriority.Medium);
            service.ChangeStatus(issueId, IssueStatus.InProgress);
            service.UndoLastCommand();

            // Act
            service.RedoCommand();

            // Assert
            var issue = service.GetIssue(issueId);
            Assert.Equal(IssueStatus.InProgress, issue.Status);
        }

        [Fact]
        public void Observer_ShouldBeNotifiedOfCommands()
        {
            // Arrange
            var repository = new IssueRepository();
            var commandManager = new CommandManager();
            var service = new IssueService(repository, commandManager);
            var mockObserver = new MockObserver();
            commandManager.RegisterObserver(mockObserver);

            // Act
            service.CreateIssue("Test Issue", "Description", IssuePriority.Medium);

            // Assert
            Assert.Equal(1, mockObserver.UpdateCallCount);
        }

        [Fact]
        public void StatisticsCollector_ShouldTrackCommandCounts()
        {
            // Arrange
            var repository = new IssueRepository();
            var commandManager = new CommandManager();
            var service = new IssueService(repository, commandManager);
            var statsCollector = new StatisticsCollector();
            commandManager.RegisterObserver(statsCollector);

            // Act
            service.CreateIssue("Issue 1", "Description", IssuePriority.Medium);
            service.CreateIssue("Issue 2", "Description", IssuePriority.High);
            service.CreateIssue("Issue 3", "Description", IssuePriority.Low);

            // Assert
            var counts = statsCollector.GetCommandCounts();
            Assert.Equal(3, counts[CommandType.Create]);
            Assert.Equal(0, counts[CommandType.Update]);
            Assert.Equal(0, counts[CommandType.Delete]);
            Assert.Equal(3, statsCollector.GetIssuesCreated());
        }

        [Fact]
        public void Logger_ShouldStoreCommandHistoryLogs()
        {
            // Arrange
            var repository = new IssueRepository();
            var commandManager = new CommandManager();
            var service = new IssueService(repository, commandManager);
            var logger = new Logger();
            commandManager.RegisterObserver(logger);

            // Act
            service.CreateIssue("Test Issue", "Description", IssuePriority.Medium);
            service.CreateIssue("Another Issue", "Description", IssuePriority.High);

            // Assert
            var logs = logger.GetLogs();
            IEnumerable<string> logList = logs.ToList();
            Assert.Equal(2, logList.Count());
            Assert.Contains("Created issue: Test Issue", logList.First());
        }

        [Fact]
        public void MultipleObservers_ShouldAllBeNotified()
        {
            // Arrange
            var repository = new IssueRepository();
            var commandManager = new CommandManager();
            var service = new IssueService(repository, commandManager);
            
            var mockObserver1 = new MockObserver();
            var mockObserver2 = new MockObserver();
            var mockObserver3 = new MockObserver();
            
            commandManager.RegisterObserver(mockObserver1);
            commandManager.RegisterObserver(mockObserver2);
            commandManager.RegisterObserver(mockObserver3);

            // Act
            service.CreateIssue("Test Issue", "Description", IssuePriority.Medium);

            // Assert
            Assert.Equal(1, mockObserver1.UpdateCallCount);
            Assert.Equal(1, mockObserver2.UpdateCallCount);
            Assert.Equal(1, mockObserver3.UpdateCallCount);
        }

        [Fact]
        public void RemoveObserver_ShouldStopNotifications()
        {
            // Arrange
            var repository = new IssueRepository();
            var commandManager = new CommandManager();
            var service = new IssueService(repository, commandManager);
            
            var mockObserver = new MockObserver();
            commandManager.RegisterObserver(mockObserver);
            
            // Act
            service.CreateIssue("First Issue", "Description", IssuePriority.Medium);
            commandManager.RemoveObserver(mockObserver);
            service.CreateIssue("Second Issue", "Description", IssuePriority.High);

            // Assert
            Assert.Equal(1, mockObserver.UpdateCallCount);
        }

        [Fact]
        public void CommandHistory_ShouldTrackAllExecutedCommands()
        {
            // Arrange
            var repository = new IssueRepository();
            var commandManager = new CommandManager();
            var service = new IssueService(repository, commandManager);

            // Act
            service.CreateIssue("Issue 1", "Description", IssuePriority.Medium);
            service.CreateIssue("Issue 2", "Description", IssuePriority.High);
            var issueId = service.CreateIssue("Issue 3", "Description", IssuePriority.Low);
            service.ChangeStatus(issueId, IssueStatus.InProgress);

            // Assert
            var history = service.GetCommandHistory().ToList();
            Assert.Equal(4, history.Count);
            Assert.Contains("Created issue: Issue 1", history[0].Description);
            Assert.Contains("Created issue: Issue 2", history[1].Description);
            Assert.Contains("Created issue: Issue 3", history[2].Description);
            Assert.Contains("Changed issue", history[3].Description);
        }

        [Fact]
        public void UndoRedo_ShouldMaintainProperStacks()
        {
            // Arrange
            var repository = new IssueRepository();
            var commandManager = new CommandManager();
            var service = new IssueService(repository, commandManager);
            int issueId = service.CreateIssue("Test Issue", "Description", IssuePriority.Medium);
            service.ChangeStatus(issueId, IssueStatus.InProgress);
            service.ChangeStatus(issueId, IssueStatus.UnderReview);

            // Act & Assert
            // Undo twice
            service.UndoLastCommand();
            var issue = service.GetIssue(issueId);
            Assert.Equal(IssueStatus.InProgress, issue.Status);
            
            service.UndoLastCommand();
            issue = service.GetIssue(issueId);
            Assert.Equal(IssueStatus.Open, issue.Status);
            
            // Redo once
            service.RedoCommand();
            issue = service.GetIssue(issueId);
            Assert.Equal(IssueStatus.InProgress, issue.Status);
            
            // New command clears redo stack
            service.ChangeStatus(issueId, IssueStatus.Resolved);
            issue = service.GetIssue(issueId);  // Get fresh copy
            Assert.Equal(IssueStatus.Resolved, issue.Status);
            
            // Try to redo (should do nothing as redo stack was cleared)
            service.RedoCommand();
            issue = service.GetIssue(issueId);  // Get fresh copy
            Assert.Equal(IssueStatus.Resolved, issue.Status);  // Should stay Resolved
        }

        [Fact]
        public void Issue_Clone_ShouldCreateCompleteDeepCopy()
        {
            var createdDate = DateTime.Now.AddDays(-1);
            var modifiedDate = DateTime.Now;
            var commentDate = DateTime.Now.AddHours(-2);
            // Arrange
            var original = new Issue
            {
                Id = 1,
                Title = "Original Title",
                Description = "Original Description",
                Priority = IssuePriority.High,
                Status = IssueStatus.Open,
                CreatedDate = createdDate,
                LastModifiedDate = modifiedDate,
                AssignedTo = "User1",
                Tags = ["bug", "critical"]
            };
            original.Comments.Add(new Comment 
            { 
                Id = 1, 
                Content = "Original Comment", 
                Author = "User2", 
                CreatedDate = commentDate 
            });

            // Act
            var clone = original.Clone();
            
            // Modify original
            original.Id = 2;
            original.Title = "Modified Title";
            original.Description = "Modified Description";
            original.Priority = IssuePriority.Low;
            original.Status = IssueStatus.InProgress;
            original.AssignedTo = "User3";
            original.Tags.Add("frontend");
            original.Comments.Add(new Comment { Id = 2, Content = "New Comment", Author = "User3", CreatedDate = DateTime.Now });
            original.Comments[0].Content = "Modified Comment";

            // Assert
            Assert.Equal(1, clone.Id);
            Assert.Equal("Original Title", clone.Title);
            Assert.Equal("Original Description", clone.Description);
            Assert.Equal(IssuePriority.High, clone.Priority);
            Assert.Equal(IssueStatus.Open, clone.Status);
            Assert.Equal(createdDate, clone.CreatedDate);
            Assert.Equal(modifiedDate, clone.LastModifiedDate);
            Assert.Equal("User1", clone.AssignedTo);
            
            // Verify collections
            Assert.Equal(3, original.Tags.Count);
            Assert.Equal(2, original.Comments.Count);

            
            // Verify clone tags collection
            Assert.Collection(clone.Tags,
                tag1 => Assert.Equal("bug", tag1),
                tag2 => Assert.Equal("critical", tag2)
            );

            // Verify comments collection
            Assert.Collection(clone.Comments,
                comment => {
                    Assert.Equal(1, comment.Id);
                    Assert.Equal("Original Comment", comment.Content);
                    Assert.Equal("User2", comment.Author);
                    Assert.Equal(commentDate, comment.CreatedDate);
                }
            );
        }

        [Fact]
        public void ChangeIssueStatusCommand_ShouldLogCorrectDescription()
        {
            // Arrange
            var repository = new IssueRepository();
            var commandManager = new CommandManager();
            var logger = new Logger();
            commandManager.RegisterObserver(logger);
            var service = new IssueService(repository, commandManager);
            
            // Act
            int issueId = service.CreateIssue("Bug Fix", "Critical bug", IssuePriority.High);
            service.ChangeStatus(issueId, IssueStatus.InProgress);
            
            // Assert
            var logs = logger.GetLogs().ToList();
            Assert.Equal(2, logs.Count);
            Assert.Contains($"Changed issue #{issueId} status to InProgress", logs[1]);
        }

        [Fact]
        public void NotificationService_ShouldNotifyOnStatusChanges()
        {
            // Arrange
            var repository = new IssueRepository();
            var commandManager = new CommandManager();
            var notificationService = new MockNotificationService();
            commandManager.RegisterObserver(notificationService);
            var service = new IssueService(repository, commandManager);
            
            // Act
            int issueId = service.CreateIssue("Bug Fix", "Critical bug", IssuePriority.High);
            service.ChangeStatus(issueId, IssueStatus.InProgress);
            
            // Assert
            Assert.Equal(2, notificationService.NotificationCount);
        }
    }

    // Mock classes for testing
    public class MockObserver : IObserver
    {
        public int UpdateCallCount { get; private set; }

        public void Update(ICommand command)
        {
            UpdateCallCount++;
        }
    }

    public class MockNotificationService : IObserver
    {
        public int NotificationCount { get; private set; }

        public void Update(ICommand command)
        {
            NotificationCount++;
        }
    }
}