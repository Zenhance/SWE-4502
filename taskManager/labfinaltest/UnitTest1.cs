using Xunit.Sdk;
using labfinal_210042111;
using System.Xml.Linq;


namespace labfinaltest
{
    public class UnitTest1
    {
      //Issue #F01: Create Issue Test
        [Fact]
        public void CreateIssueTest()
        {
            
            CommandInvoker invoker = new CommandInvoker();
            Issue issue = new Issue(1, "FIRST", "FIRST Description", Priority.medium, "Alice");
            IssueRepository repository=new IssueRepository(1, issue);
            CreateIssueCommand createCommand = new CreateIssueCommand(repository, issue);
            invoker.executeCommand(createCommand);
            Issue retrieved = repository.getIssue(1);
            
            Assert.NotNull(retrieved);
            Assert.Equal("FIRST", retrieved.getTitle());
           
            Assert.Equal(Status.open, retrieved.getStatus());


        }

       // Issue #F02: Add Comment Test

        [Fact]

        public void AddComment_ShouldAddCommentToIssue() {
            CommandInvoker invoker = new CommandInvoker();
                 
            Issue issue = new Issue(2, "Commenting on issue", "Description for comment", Priority.high, "Sheona");
            IssueRepository repository = new IssueRepository(2, issue);
            repository.addIssue(issue);
            Comment comment = new Comment(1, "this is a comment for test", "Sheona");
            AddCommentCommand addCommentCommand = new AddCommentCommand(repository, issue, comment);
            invoker.executeCommand(addCommentCommand);


         
            Assert.Equal("this is a comment for test", issue.GetComment()[0].Content);

        }
    }


 




}