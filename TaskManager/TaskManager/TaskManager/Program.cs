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
            var repository = new IssueRepository();
            var commandManager = new CommandManager();
            var notificationService = new NotificationService();
            var statisticsService = new StatisticsService();

            var issue = new Issue
            {
                Title = "Implement Login Feature",
                Description = "Add user authentication and authorization",
                Priority = Priority.High,
                AssignedTo = "Tamim Al Hasan",
                Tags = { "authentication", "security" }
            };

            var createCommand = new CreateIssueCommand(repository, issue);
            commandManager.ExecuteCommand(createCommand);
            statisticsService.TrackCommand(createCommand.Type);
            notificationService.NotifyIssueCreated(issue);

            issue.Status = Status.InProgress;
            var updateCommand = new UpdateIssueCommand(repository, issue);
            commandManager.ExecuteCommand(updateCommand);
            statisticsService.TrackCommand(updateCommand.Type);
            notificationService.NotifyStatusChanged(issue, Status.Open.ToString());

            var comment = new Comment
            {
                Content = "Started working on the authentication module",
                Author = "MS Virat"
            };
            issue.Comments.Add(comment);
            var updateWithCommentCommand = new UpdateIssueCommand(repository, issue);
            commandManager.ExecuteCommand(updateWithCommentCommand);
            statisticsService.TrackCommand(updateWithCommentCommand.Type);
            notificationService.NotifyCommentAdded(issue, comment);

            Console.WriteLine("\nUndoing last command...");
            commandManager.Undo();

            statisticsService.PrintStatistics();

            Console.WriteLine("\nCommand Logs:");
            foreach (var log in commandManager.GetCommandLogs())
            {
                Console.WriteLine($"{log.Timestamp}: {log.Type} - {log.Description}");
            }
        }
    }
}