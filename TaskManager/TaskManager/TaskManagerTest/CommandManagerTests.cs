using System;
using Xunit;
using TaskManager.Commands;
using TaskManager.Models;
using TaskManager.Repository;
using TaskManager.Enums;
using TaskManager.Commands.TaskManager.Commands;

namespace TaskManager.Tests
{
    public class CommandManagerTests
    {
        //#F04
        [Fact]
        public void UndoCommand_ShouldRevertLastAction()
        {
            var repository = new IssueRepository();
            var commandManager = new CommandManager();
            var issue = new Issue
            {
                Title = "Test Issue",
                Description = "Test Description",
                Priority = Priority.Medium
            };
            var createCommand = new CreateIssueCommand(repository, issue);

            commandManager.ExecuteCommand(createCommand);
            commandManager.Undo();
            Assert.Empty(repository.GetAll());
        }
        //#F05
        [Fact]
        public void RedoCommand_ShouldReapplyUndoneAction()
        {
            var repository = new IssueRepository();
            var commandManager = new CommandManager();
            var issue = new Issue
            {
                Title = "Test Issue",
                Description = "Test Description",
                Priority = Priority.Medium
            };
            var createCommand = new CreateIssueCommand(repository, issue);

            commandManager.ExecuteCommand(createCommand);
            commandManager.Undo();
            commandManager.Redo();

            var retrievedIssue = repository.GetById(issue.Id);
            Assert.Equal("Test Issue", retrievedIssue.Title);
            Assert.Equal("Test Description", retrievedIssue.Description);
            Assert.Equal(Priority.Medium, retrievedIssue.Priority);
        }
        //#F08
        [Fact]
        public void Logger_ShouldStoreCommandHistoryLogs()
        {
            var repository = new IssueRepository();
            var commandManager = new CommandManager();
            var issue = new Issue
            {
                Title = "Test Issue",
                Description = "Test Description",
                Priority = Priority.Medium
            };

            commandManager.ExecuteCommand(new CreateIssueCommand(repository, issue));
            issue.Status = Status.InProgress;
            commandManager.ExecuteCommand(new UpdateIssueCommand(repository, issue));

            var logs = commandManager.GetCommandLogs();
            Assert.Equal(2, logs.Count);
            Assert.Contains(logs, l => l.Type == CommandType.Create);
            Assert.Contains(logs, l => l.Type == CommandType.Update);
        }
        //#F11
        [Fact]
        public void CommandHistory_ShouldTrackAllExecutedCommands()
        {
            var repository = new IssueRepository();
            var commandManager = new CommandManager();
            var issue1 = new Issue { Title = "Issue 1" };
            var issue2 = new Issue { Title = "Issue 2" };
            var issue3 = new Issue { Title = "Issue 3" };

            commandManager.ExecuteCommand(new CreateIssueCommand(repository, issue1));
            commandManager.ExecuteCommand(new CreateIssueCommand(repository, issue2));
            commandManager.ExecuteCommand(new CreateIssueCommand(repository, issue3));

            var logs = commandManager.GetCommandLogs();
            Assert.Equal(3, logs.Count);
            Assert.Equal("Created issue: Issue 1", logs[0].Description);
            Assert.Equal("Created issue: Issue 2", logs[1].Description);
            Assert.Equal("Created issue: Issue 3", logs[2].Description);
        }
    }
}