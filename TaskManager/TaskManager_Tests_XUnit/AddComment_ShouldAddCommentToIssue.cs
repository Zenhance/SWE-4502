using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Xml.Linq;
using TaskManager;

namespace TaskManager_Tests_XUnit
{
    public class AddComment_ShouldAddCommentToIssue
    {
        [Fact]
        public void AddComment_Test_Method()
        {
            IssueRepository repo = new IssueRepository();
            Issue issue = new Issue(1, "Test Issue", "Test Description", Priority.Medium);
            CreateIssueCommand createCommand = new CreateIssueCommand(repo, issue);
            CommandManager undoRedoManager = new CommandManager();
            undoRedoManager.ExecuteCommand(createCommand);

            Comments comment = new Comments(1, "Test comment", "Author");
            issue.comments.Add(comment);

            Assert.Contains(comment, issue.comments);
            Assert.Equal("Test comment", comment.content);
        }
    }
}
