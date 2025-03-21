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
            var issue = new Issue(1, "Test Issue", "Test Description", Priority.Medium);
            var createCommand = new CreateIssueCommand(repo, issue);


            var retrievedIssue = repo.GetIssue(1);

            Assert.AreEqual(1, retrievedIssue.Id);
        }



    }
}
