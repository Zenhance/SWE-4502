using System;
using TaskManager.Commands;
using TaskManager.Commands.TaskManager.Commands;
using TaskManager.Enums;
using TaskManager.Models;
using TaskManager.Models.TaskManager.Models;
using TaskManager.Repository;
using TaskManager.Services;

namespace TaskManager
{
    class Program
    {
        static void Main(string[] args)
        {
            // Initialize services
            var repository = new IssueRepository();
            var commandManager = new CommandManager();
            var notificationService = new NotificationService();
            var statisticsService = new StatisticsService();

            // Create a new issue
            var issue = new Issue
            {
                Title = "Implement Login Feature",
                Description = "Add user authentication and authorization",
                Priority = Priority.High,
                AssignedTo = "John Doe",
                Tags = { "authentication", "security" }
            };

            var createCommand = new CreateIssueCommand(repository, issue);
            commandManager.ExecuteCommand(createCommand);
            statisticsService.TrackCommand(createCommand.Type);
            notificationService.NotifyIssueCreated(issue);

            // Update issue status
            issue.Status = Status.InProgress;
            var updateCommand = new UpdateIssueCommand(repository, issue);
            commandManager.ExecuteCommand(updateCommand);
            statisticsService.TrackCommand(updateCommand.Type);
            notificationService.NotifyStatusChanged(issue, Status.Open.ToString());

            // Add a comment
            var comment = new Comment
            {
                Content = "Started working on the authentication module",
                Author = "John Doe"
            };
            issue.Comments.Add(comment);
            var updateWithCommentCommand = new UpdateIssueCommand(repository, issue);
            commandManager.ExecuteCommand(updateWithCommentCommand);
            statisticsService.TrackCommand(updateWithCommentCommand.Type);
            notificationService.NotifyCommentAdded(issue, comment);

            // Undo last command
            Console.WriteLine("\nUndoing last command...");
            commandManager.Undo();

            // Print statistics
            statisticsService.PrintStatistics();

            // Print command logs
            Console.WriteLine("\nCommand Logs:");
            foreach (var log in commandManager.GetCommandLogs())
            {
                Console.WriteLine($"{log.Timestamp}: {log.Type} - {log.Description}");
            }
        }
    }
}