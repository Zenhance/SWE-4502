using Xunit.Sdk;
using labfinal_210042111;


namespace labfinaltest
{
    public class UnitTest1
    {
        [Fact]
        public void Test1()
        {
            
          //invoker
          

            Issue issue = new Issue(1, "FIRST", "FIRST Description", Priority.medium, "Alice");
            IssueRepository repository=new IssueRepository(1, issue);
            CreateIssueCommand createCommand = new CreateIssueCommand(repository, issue);
            //invoker.executeCommand(createCommand);
            Issue retrieved = repository.getIssue(1);
            //assert


        }
    }

  




}