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
        //#F02
        [Fact]
        public void AddComment_ShouldAddCommentToIssue()
        {
            var repository = new IssueRepository();
            var issue = new Issue
            {
                Title = "Test Issue",
                Description = "Test Description"
            };
            repository.Add(issue);
            var comment = new Comment
            {
                Content = "This is a comment",
                Author = "User1"
            };

            issue.Comments.Add(comment);
            repository.Update(issue);

            var retrievedIssue = repository.GetById(issue.Id);
            Assert.Single(retrievedIssue.Comments);
            Assert.Equal("This is a comment", retrievedIssue.Comments[0].Content);
            Assert.Equal("User1", retrievedIssue.Comments[0].Author);
        }
        //#F03
        [Fact]
        public void ChangeStatus_ShouldUpdateIssueStatus()
        {
            var repository = new IssueRepository();
            var commandManager = new CommandManager();
            var issue = new Issue
            {
                Title = "Bug Report",
                Description = "Critical bug needs fixing",
                Priority = Priority.High,
                Status = Status.Open
            };
            repository.Add(issue);

            issue.Status = Status.InProgress;
            var updateCommand = new UpdateIssueCommand(repository, issue);
            commandManager.ExecuteCommand(updateCommand);

            var retrievedIssue = repository.GetById(issue.Id);
            Assert.Equal(Status.InProgress, retrievedIssue.Status);
        }
    }
}