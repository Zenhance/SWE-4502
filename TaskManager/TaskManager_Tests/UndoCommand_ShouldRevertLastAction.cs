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
    public class UndoCommand_ShouldRevertLastAction
    {
        [TestMethod]
        public void UndoCommand_Test_Method()
        {
            IssueRepository repo = new IssueRepository();
            Issue issue = new Issue(1, "Test Issue", "Test Description", Priority.Medium);
            CreateIssueCommand createIssueCommand = new CreateIssueCommand(repo, issue);
            CommandManager commandManager = new CommandManager();

            commandManager.ExecuteCommand(createIssueCommand);

            commandManager.Undo();

            var retrievedIssue = repo.GetIssue(1);
            Assert.IsNull(retrievedIssue);
        }
    }
}
