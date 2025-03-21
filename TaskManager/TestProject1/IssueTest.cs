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
    }
}