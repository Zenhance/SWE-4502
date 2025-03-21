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
    }
}