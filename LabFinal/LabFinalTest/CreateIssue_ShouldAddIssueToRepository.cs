using LabFinalTask.Command;
using LabFinalTask.Core;
using LabFinalTask.ENUM;
using LabFinalTask.Mediator;
using LabFinalTask.Model;

namespace LabFinal;

public class CreateIssue_ShouldAddIssueToRepository
{
    [Fact]
    public void CreateIssueTest()
    {
        User shuvro = new User("shuvro");
        UserMediator userMediator = new UserMediator();

        IssueManager issueManager = new IssueManager(userMediator);

        Issue issue1 = new Issue("button round", "round the buttons", PRIORITY.LOW, STATUS.OPEN, shuvro);

        ICommand create_first_issue = new IssueCreateCommand(issueManager, issue1);
        create_first_issue.execute();
        
        Assert.Equal(issue1, issueManager.issues[0]);
    }
}