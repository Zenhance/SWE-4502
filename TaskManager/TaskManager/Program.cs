using TaskManager.Observers;
using TaskManager.Repository;
using TaskManager.Service;
using TaskManager.Subjects;

namespace TaskManager
{
    public class Program
    {
        public static void Main(string[] args)
        {
            // Setup dependencies
            var repository = new IssueRepository();
            var commandManager = new CommandManager();
            var issueService = new IssueService(repository, commandManager);
            
            // Register observers
            var logger = new Logger();
            var notificationService = new NotificationService();
            var statisticsCollector = new StatisticsCollector();
            
            commandManager.RegisterObserver(logger);
            commandManager.RegisterObserver(notificationService);
            commandManager.RegisterObserver(statisticsCollector);
            
            var ui = new ConsoleUI(issueService);
            ui.Run();
        }
    }
}