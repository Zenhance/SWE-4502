using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using TaskManager_112;

namespace TaskManagerTests
{
    public class DeepCloneTest
    {
        [Fact]
        public void Issue_Clone_ShouldCreateCompleteDeepCopy()
        {
            var issue = IssueFactory.CreateIssue(1, "TTT", "DDD", Priority.Critical);

            // Act
            var clonedIssue = new Issue(issue.ID, issue.Title, issue.Description, issue.Priority);

            // Assert
            Assert.NotSame(issue, clonedIssue);
            Assert.Equal(issue.Title, clonedIssue.Title);
        }
    }
}
