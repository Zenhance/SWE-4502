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
        //#F13
        [Fact]
        public void Issue_Clone_ShouldCreateCompleteDeepCopy()
        {
            var originalIssue = new Issue
            {
                Title = "Original Issue",
                Description = "Original Description",
                Priority = Priority.Medium,
                Status = Status.Open,
                AssignedTo = "User1"
            };
            originalIssue.Tags.Add("Bug");
            originalIssue.Tags.Add("UI");
            originalIssue.Comments.Add(new Comment
            {
                Content = "Original Comment",
                Author = "User2"
            });

            var clonedIssue = new Issue
            {
                Title = originalIssue.Title,
                Description = originalIssue.Description,
                Priority = originalIssue.Priority,
                Status = originalIssue.Status,
                AssignedTo = originalIssue.AssignedTo
            };

            foreach (var tag in originalIssue.Tags)
            {
                clonedIssue.Tags.Add(tag);
            }

            foreach (var comment in originalIssue.Comments)
            {
                clonedIssue.Comments.Add(new Comment
                {
                    Content = comment.Content,
                    Author = comment.Author,
                    CreatedAt = comment.CreatedAt
                });
            }

            originalIssue.Title = "Modified Title";
            originalIssue.Tags[0] = "Feature";
            originalIssue.Comments[0].Content = "Modified Comment";

            Assert.Equal("Original Issue", clonedIssue.Title);
            Assert.Equal("Original Description", clonedIssue.Description);
            Assert.Equal(Priority.Medium, clonedIssue.Priority);
            Assert.Equal(Status.Open, clonedIssue.Status);
            Assert.Equal("User1", clonedIssue.AssignedTo);
            Assert.Equal(2, clonedIssue.Tags.Count);
            Assert.Equal("Bug", clonedIssue.Tags[0]);
            Assert.Equal("UI", clonedIssue.Tags[1]);
            Assert.Single(clonedIssue.Comments);
            Assert.Equal("Original Comment", clonedIssue.Comments[0].Content);
            Assert.Equal("User2", clonedIssue.Comments[0].Author);
        }
        //#F14
        [Fact]
        public void ChangeIssueStatusCommand_ShouldLogCorrectDescription()
        {
            var repository = new IssueRepository();
            var commandManager = new CommandManager();
            var issue = new Issue
            {
                Title = "Task Issue",
                Status = Status.Open
            };
            repository.Add(issue);

            issue.Status = Status.InProgress;
            commandManager.ExecuteCommand(new UpdateIssueCommand(repository, issue));

            var logs = commandManager.GetCommandLogs();
            Assert.Single(logs);
            Assert.Contains("Updated issue", logs[0].Description);
            Assert.Equal(CommandType.Update, logs[0].Type);
        }
    }
}