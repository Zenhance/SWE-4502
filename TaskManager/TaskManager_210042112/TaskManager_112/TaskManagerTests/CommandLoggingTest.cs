using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using TaskManager_112;

namespace TaskManagerTests
{
    public class CommandLoggingTest
    {
        [Fact]
        public void Logger_ShouldStoreCommandHistoryLogs()
        {
            var repo = new IssueRepository();
            var issue = IssueFactory.CreateIssue(1, "TT", "...", Priority.Medium);
            var createIssueCommand = new CreateIssueCommand(repo, issue);
            var invoker = new CommandInvoker();
            var logger = new CommandLogger();

            // Act
            invoker.ExecuteCommand(createIssueCommand);
            logger.AddLogs("issue created but at what cost");
            

        }
    }
}
