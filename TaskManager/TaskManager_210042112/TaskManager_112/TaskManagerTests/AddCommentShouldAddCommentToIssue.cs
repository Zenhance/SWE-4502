using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using TaskManager_112;

namespace TaskManagerTests
{
    public class AddCommentShouldAddCommentToIssue
    {
        [Fact]
        public void AddComment_ShouldAddCommentToIssue()
        {
            var repository = new IssueRepository();
            var issue = IssueFactory.CreateIssue(1, "Second Issue", "Description", Priority.Medium);
            var createIssueCommand = new CreateIssueCommand(repository, issue);
            var invoker = new CommandInvoker();
            invoker.ExecuteCommand(createIssueCommand);

            var comment = new Comment(1, "Medium priority", "Namisa");

            // Act
            issue.AddComment(comment);

            // Assert
            Assert.Single(issue.Comments);
            Assert.Equal("Medium priority", issue.Comments[0].Content);
            Assert.Equal("Namisa", issue.Comments[0].Author);
        }
    }
}
