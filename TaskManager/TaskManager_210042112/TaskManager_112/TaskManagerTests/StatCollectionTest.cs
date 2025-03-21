using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using TaskManager_112;

namespace TaskManagerTests
{
    public class StatCollectionTest
    {
        [Fact]
        public void StatisticsCollector_ShouldTrackCommandCounts()
        {
            var repo = new IssueRepository();
            var issue = IssueFactory.CreateIssue(1, "Lame", "Description : Dead", Priority.Medium);
            var createIssue = new CreateIssueCommand(repo, issue);
            var invoker = new CommandInvoker();

            // Act
            invoker.ExecuteCommand(createIssue);
            invoker.ExecuteCommand(new ChangeIssueStatusCommand(issue, Status.InProgress));


            // Assert
            
        }
    }
}
