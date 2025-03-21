using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using TaskManager_112;

namespace TaskManagerTests
{
    public class RedoCommandTest
    {
        [Fact]
        public void RedoCommand_ShouldReapplyUndoneAction()
        {
            var repo = new IssueRepository();
            var iss = IssueFactory.CreateIssue(12, "Ugh", "Papercut2", Priority.High);

            var createissue = new CreateIssueCommand(repo, iss);
            var invoke_the_joker = new CommandInvoker();
            invoke_the_joker.ExecuteCommand(createissue);

            var changestatus = new ChangeIssueStatusCommand(iss, Status.Resolved);
            invoke_the_joker.ExecuteCommand(changestatus);

            
            invoke_the_joker.Undo();

            //Act
            invoke_the_joker.Redo();

            //Assert
            Assert.Equal(Status.Resolved, iss.Status);
        }
    }
}
