using Microsoft.VisualStudio.TestTools.UnitTesting;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using TaskManager;

namespace TaskManager_Tests
{

    [TestClass]
    public class ChangeStatus_ShouldUpdateIssueStatus
    {
        [TestMethod]
        public void ChangeStatus_Test_Method()
        {
            IssueRepository repo = new IssueRepository();
            Issue issue = new Issue(1, "Test Issue", "Test Description", Priority.Medium);
            CreateIssueCommand createCommand = new CreateIssueCommand(repo, issue);
            CommandManager commandManager = new CommandManager();
            commandManager.ExecuteCommand(createCommand);

            ChangeStatusCommand changeStatusCommand = new ChangeStatusCommand(repo, issue, Status.InProgress);
            commandManager.ExecuteCommand(changeStatusCommand);

            Assert.AreEqual(Status.InProgress, issue.status);
        }
    }
}
