using System;
using TaskManager;

namespace TestProject1
{
    public class IssueTests
    {
        private readonly IssueRepository _repository;

        public IssueTests()
        {
            _repository = new IssueRepository();
        }


        [Fact]
        public void CreateIssue_ShouldAddIssueToRepository()
        {
            {
                var issue = new Issue { Id = 1, Title = "Bug in UI", Description = "Submit button is not working" };

                // Act & Assert
                Assert.NotNull(issue);
                Assert.Equal(Status.Open, issue.Status);
                Assert.NotEqual(0, issue.Id);
                Assert.Equal("Bug in UI", issue.Title);
            }

        }


        [Fact]

        public void AddComment_ShouldIncreaseCommentCount()
        {
            // Arrange
        Issue issue = new Issue(1, "Bug in Login", "Login button not working", Priority.High, "JohnDoe");
            int initialCount = issue.Comments.Count;

            // Act
            issue.AddComment(101, "This issue needs urgent attention!", "JaneDoe");

            // Assert
            Assert.Equal(initialCount + 1, issue.Comments.Count);

        }

        [Fact]
        public void ChangeStatus_ShouldUpdateIssueStatus()
        {
            // Arrange: Create an issue with default status (Open)
            var issue = new Issue(1, "Bug in Login", "Fix login issue", Priority.High, "John Doe");

            // Act: Change the status to 'Resolved'
            issue.UpdateStatus(Status.Resolved);

            // Assert: Verify that the status is updated correctly
            Assert.Equal(Status.Resolved, issue.Status);

            // Assert: Ensure that LastModifiedDate is updated
            Assert.True(issue.LastModifiedDate >= issue.CreationDate);
        }

        [Fact]
        public void UndoCommand_ShouldRevertLastAction()
        {

        }
    }
}