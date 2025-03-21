using TaskManager.Command;
using TaskManager.Core;
using TaskManager.ENUM;
using TaskManager.Model;

namespace TaskManagerTest;

public class ChangeStatus_ShouldUpdateIssueStatus
{
    [Test]
    public void TestChangeStatus()
    {
        User rayshad = new User("rayshad");
        UserMediator userMediator = new UserMediator();
        
        IssueManager issueManager = new IssueManager(userMediator);
        
        Issue issue1 = new Issue("FILL BUTTON", "fILL BUTTON WITH BLUE COLOR", IssuePriorityENUM.LOW,
            IssueStatusENUM.OPEN, rayshad);
        
        ICommand create = new IssueCreateCommand(issueManager, issue1);
        
        create.execute();

        ICommand chnage_status = new IssueUpdateStatusCommand(issueManager, issue1, IssueStatusENUM.RESOLVED);
        chnage_status.execute();
        
        Assert.AreEqual(IssueStatusENUM.RESOLVED, issue1._status);


    }
}