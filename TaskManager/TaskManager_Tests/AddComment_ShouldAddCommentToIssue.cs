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
    public class AddComment_ShouldAddCommentToIssue
    {
        [TestMethod]
        public void AddComment_Test_Method()
        {
            IssueRepository repo = new IssueRepository();
            Issue issue = new Issue(1, "Test Issue", "Test Description", Priority.Medium);
            CreateIssueCommand createCommand = new CreateIssueCommand(repo, issue);
            CommandManager commandManager = new CommandManager();
            commandManager.ExecuteCommand(createCommand);

            Comments comment = new Comments(1, "Test comment", "Author");
            issue.comments.Add(comment);

            Assert.AreEqual(null, comment.content);//
        }

    }
}

