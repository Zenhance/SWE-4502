using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using TaskManager_112;

namespace TaskManagerTests
{
    public class UndoCommandTest
    {
        [Fact]
        public void UndoCommand_ShouldRevertLastAction()
        {
            var repo = new IssueRepository();
            var iss = IssueFactory.CreateIssue(12, "LOL","Papercut", Priority.Low);

            var createissue = new CreateIssueCommand(repo, iss);
            var invoke_the_joker = new CommandInvoker();
            invoke_the_joker.ExecuteCommand(createissue);

            var changestatus = new ChangeIssueStatusCommand(iss, Status.Resolved);
            invoke_the_joker.ExecuteCommand(changestatus);

            //Act
            invoke_the_joker.Undo();

            //Assert
            Assert.Equal(Status.UnderReview,iss.Status);

        }

    }
}
