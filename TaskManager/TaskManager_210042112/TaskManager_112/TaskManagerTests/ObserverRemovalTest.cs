using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using TaskManager_112;

namespace TaskManagerTests
{
    public class ObserverRemovalTest
    {
        [Fact]
        public void RemoveObserver_ShouldStopNotifications()
        {
            var repo = new IssueRepository();
            var issue = IssueFactory.CreateIssue(122, "Last?", "LLL", Priority.Low);
            var createIssue = new CreateIssueCommand(repo, issue);
            var invoker = new CommandInvoker();
            var issueManager = new IssueManager();
            var observer1 = new IssueObserver("namisa");
            issueManager.Attach(observer1);
            issueManager.Detach(observer1);

            // Act
            invoker.ExecuteCommand(createIssue);
            issueManager.Notify("Issue Created: " + issue.Title);
            
        }
    }
}
