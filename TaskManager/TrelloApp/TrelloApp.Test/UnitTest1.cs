using static TrelloApp.Issue;

namespace TrelloApp.Test
{
    public class UnitTest1
    {
        [Fact]
        public void CreateIssue_ShouldAddIssueToRepository()
        {
            int id = 1;
            Issue issue = new Issue(id, "Change Password", "Dummy description", Issue.priority.Low, 
                Issue.status.Open, 21);

            IssueRepository repository = new IssueRepository(issue);

            repository.createIssue(issue);

            Assert.True(repository.issues.ContainsKey(id)); 
            var addedIssue = repository.issues[id];

            Assert.Equal(issue.title, addedIssue.title); 
            Assert.Equal(issue.description, addedIssue.description); 
            Assert.Equal(Issue.priority.Low, addedIssue.priorityType); 
            Assert.Equal(Issue.status.Open, addedIssue.statusType); 
            Assert.Equal(issue.creationDate, addedIssue.creationDate);
        }
    }
}