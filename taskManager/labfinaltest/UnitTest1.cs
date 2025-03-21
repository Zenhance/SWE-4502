using Xunit.Sdk;
using labfinal_210042111;


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
    }

  




}