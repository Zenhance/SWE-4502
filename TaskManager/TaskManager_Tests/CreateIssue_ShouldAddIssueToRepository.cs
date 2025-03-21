using System;
using System.Collections.Generic;
using Microsoft.VisualStudio.TestTools.UnitTesting;
using TaskManager;

namespace TaskManager_Tests
{
    [TestClass]
    public class CreateIssue_ShouldAddIssueToRepository
    {

        [TestMethod]
        public void CreateIssue_Test_Method()
        {
            IssueRepository repo = new IssueRepository();
            Issue issue = new Issue(1, "Test Issue", "Test Description", Priority.Medium);
            CreateIssueCommand createIssueCommand = new CreateIssueCommand(repo, issue);
            CommandManager commandManager = new CommandManager();

            commandManager.ExecuteCommand(createIssueCommand);


            var retrievedIssue = repo.GetIssue(1);

            Assert.AreEqual(1, retrievedIssue.Id);
            Assert.AreEqual("Test Issue", retrievedIssue.Title);

        }



    }
}
