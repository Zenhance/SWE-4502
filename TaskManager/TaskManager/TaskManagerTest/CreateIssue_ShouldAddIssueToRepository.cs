using TaskManager.Command;
using TaskManager.Core;
using TaskManager.ENUM;
using TaskManager.Model;

namespace TaskManagerTest;

public class CreateIssue_ShouldAddIssueToRepository
{
    [Test]
    public void TestCreateIssue()
    {
        User rayshad = new User("rayshad");
        UserMediator userMediator = new UserMediator();
        
        IssueManager issueManager = new IssueManager(userMediator);

        Issue issue1 = new Issue("FILL BUTTON", "fILL BUTTON WITH BLUE COLOR", IssuePriorityENUM.LOW,
            IssueStatusENUM.OPEN, rayshad);
        
        ICommand create = new IssueCreateCommand(issueManager, issue1);
        
        create.execute();
        
        Assert.AreEqual(issue1, issueManager._issues[0]) ;
    }
    
}