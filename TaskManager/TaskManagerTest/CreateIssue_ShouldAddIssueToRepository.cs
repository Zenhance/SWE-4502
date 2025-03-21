using TaskManager.Command;
using TaskManager.Core;
using TaskManager.ENUM;
using TaskManager.Mediator;
using TaskManager.Model;

namespace TaskManager;

public class CreateIssue_ShouldAddIssueToRepository
{
    [Fact]
    public void CreateIssueTest()
    {
        User Abrar = new User("Abrar");
        UserMediator userMediator = new UserMediator();

        IssueManager issueManager = new IssueManager(userMediator);

        Issue issue1 = new Issue("button round", "round the buttons", PRIORITY.LOW, STATUS.OPEN, Abrar);

        ICommand create_first_issue = new IssueCreateCommand(issueManager, issue1);
        create_first_issue.execute();
        
        Assert.Equal(issue1, issueManager.issues[0]);
    }
}