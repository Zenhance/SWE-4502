using System;
using System.Linq;
using Xunit;
using TaskManager.Models;
using TaskManager.Repository;
using TaskManager.Commands;
using TaskManager.Enums;
using TaskManager.Commands.TaskManager.Commands;
using TaskManager.Models.TaskManager.Models;

namespace TaskManager.Tests
{
    public class IssueManagementTests
    {
        //#F01
        [Fact]
        public void CreateIssue_ShouldAddIssueToRepository()
        {
            var repository = new IssueRepository();
            var commandManager = new CommandManager();
            var issue = new Issue
            {
                Title = "New Feature",
                Description = "Implement new feature",
                Priority = Priority.High
            };

            var createCommand = new CreateIssueCommand(repository, issue);
            commandManager.ExecuteCommand(createCommand);

            var retrievedIssue = repository.GetById(issue.Id);
            Assert.Equal("New Feature", retrievedIssue.Title);
            Assert.Equal("Implement new feature", retrievedIssue.Description);
            Assert.Equal(Priority.High, retrievedIssue.Priority);
            Assert.Equal(Status.Open, retrievedIssue.Status);
        }
    }
}