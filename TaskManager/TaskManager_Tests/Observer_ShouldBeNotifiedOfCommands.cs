using Microsoft.VisualStudio.TestTools.UnitTesting;
using System;
using System.IO;
using TaskManager;

namespace TaskManager_Tests
{
    [TestClass]
    public class Observer_ShouldBeNotifiedOfCommands
    {
        [TestMethod]
        public void Observer_ShouldBeNotified_Test_Method()
        {
            IssueRepository repo = new IssueRepository();
            Issue issue = new Issue(1, "Test Issue", "Test Description", Priority.Medium);
            CreateIssueCommand createIssueCommand = new CreateIssueCommand(repo, issue);
            CommandManager commandManager = new CommandManager();
            NotificationService notificationService = new NotificationService();

            using (StringWriter sw = new StringWriter())
            {
                Console.SetOut(sw);

                commandManager.ExecuteCommand(createIssueCommand);
                notificationService.Notify("Issue created: " + issue.Title);

                string output = sw.ToString();
                StringAssert.Contains(output, "Notification sent: Issue created: Test Issue");
            }
        }
    }
}
