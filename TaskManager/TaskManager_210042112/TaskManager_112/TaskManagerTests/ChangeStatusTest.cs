using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using TaskManager_112;

namespace TaskManagerTests
{
    public class ChangeStatusTest
    {
        [Fact]
        public void ChangeStatus_ShouldUpdateIssueStatus()
        {
            var repo = new IssueRepository();
            var issue = IssueFactory.CreateIssue(12, "Blah blah", "Description is unnecessary", Priority.Critical);

            var createissuecom = new CreateIssueCommand(repo, issue);

            var invoke = new CommandInvoker();
            invoke.ExecuteCommand(createissuecom);

            //Act
            var changestatus = new ChangeIssueStatusCommand(issue, Status.InProgress);
            invoke.ExecuteCommand(changestatus);

            //Assert
            Assert.Equal(Status.InProgress, issue.Status);

        }

    }
}
