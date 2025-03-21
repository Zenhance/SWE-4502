using System;
using System.Collections.Generic;
using Xunit;
using TaskManager.Commands;
using TaskManager.Models;
using TaskManager.Repository;
using TaskManager.Enums;
using TaskManager.Commands.TaskManager.Commands;

namespace TaskManager.Tests
{
    public class MockObserver
    {
        public List<ICommand> NotifiedCommands { get; } = new List<ICommand>();

        public void OnCommandExecuted(ICommand command)
        {
            NotifiedCommands.Add(command);
        }
    }
    public class MockStatisticsCollector
    {
        public Dictionary<CommandType, int> CommandCounts { get; } = new Dictionary<CommandType, int>
        {
            { CommandType.Create, 0 },
            { CommandType.Update, 0 },
            { CommandType.Delete, 0 }
        };

        public void TrackCommand(ICommand command)
        {
            if (CommandCounts.ContainsKey(command.Type))
            {
                CommandCounts[command.Type]++;
            }
        }
    }
    public class MockNotificationService
    {
        public List<string> Notifications { get; } = new List<string>();

        public void SendNotification(string message)
        {
            Notifications.Add(message);
        }
    }
    public class ObserverTests
    {
        //#F06
        [Fact]
        public void Observer_ShouldBeNotifiedOfCommands()
        {
            var repository = new IssueRepository();
            var commandManager = new ObservableCommandManager();
            var observer = new MockObserver();

            commandManager.AddObserver(observer.OnCommandExecuted);

            var issue = new Issue
            {
                Title = "Test Issue",
                Description = "Test Description"
            };
            var createCommand = new CreateIssueCommand(repository, issue);
            commandManager.ExecuteCommand(createCommand);

            Assert.Single(observer.NotifiedCommands);
            Assert.Equal(createCommand, observer.NotifiedCommands[0]);
        }
        //#F07
        [Fact]
        public void StatisticsCollector_ShouldTrackCommandCounts()
        {
            var repository = new IssueRepository();
            var commandManager = new ObservableCommandManager();
            var statisticsCollector = new MockStatisticsCollector();

            commandManager.AddObserver(statisticsCollector.TrackCommand);

            var issue1 = new Issue { Title = "Issue 1" };
            var issue2 = new Issue { Title = "Issue 2" };

            commandManager.ExecuteCommand(new CreateIssueCommand(repository, issue1));
            commandManager.ExecuteCommand(new CreateIssueCommand(repository, issue2));
            issue1.Status = Status.InProgress;
            commandManager.ExecuteCommand(new UpdateIssueCommand(repository, issue1));

            Assert.Equal(2, statisticsCollector.CommandCounts[CommandType.Create]);
            Assert.Equal(1, statisticsCollector.CommandCounts[CommandType.Update]);
            Assert.Equal(0, statisticsCollector.CommandCounts[CommandType.Delete]);
        }
        //#F09
        [Fact]
        public void MultipleObservers_ShouldAllBeNotified()
        {
            var repository = new IssueRepository();
            var commandManager = new ObservableCommandManager();
            var observer1 = new MockObserver();
            var observer2 = new MockObserver();
            var observer3 = new MockObserver();

            commandManager.AddObserver(observer1.OnCommandExecuted);
            commandManager.AddObserver(observer2.OnCommandExecuted);
            commandManager.AddObserver(observer3.OnCommandExecuted);

            var issue = new Issue { Title = "Test Issue" };
            var createCommand = new CreateIssueCommand(repository, issue);

            commandManager.ExecuteCommand(createCommand);

            Assert.Single(observer1.NotifiedCommands);
            Assert.Single(observer2.NotifiedCommands);
            Assert.Single(observer3.NotifiedCommands);
        }
    }
}