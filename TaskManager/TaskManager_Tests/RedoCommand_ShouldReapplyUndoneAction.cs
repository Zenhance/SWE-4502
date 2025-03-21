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
    public class RedoCommand_ShouldReapplyUndoneAction
    {
        [TestMethod]
        public void RedoCommand_Test_Method()
        {
            IssueRepository repo = new IssueRepository();
            Issue issue = new Issue(1, "Test Issue", "Test Description", Priority.Medium);
            CreateIssueCommand createIssueCommand = new CreateIssueCommand(repo, issue);
            CommandManager commandManager = new CommandManager();

            commandManager.ExecuteCommand(createIssueCommand);

            commandManager.Redo();

            var retrievedIssue = repo.GetIssue(1);
            //

        }
        
    }
}
