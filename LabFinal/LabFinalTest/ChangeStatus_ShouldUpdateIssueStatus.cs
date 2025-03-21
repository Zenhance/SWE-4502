using LabFinalTask.Command;
using LabFinalTask.Core;
using LabFinalTask.ENUM;
using LabFinalTask.Mediator;
using LabFinalTask.Model;

namespace LabFinal;

public class ChangeStatus_ShouldUpdateIssueStatus
{
    [Fact]
    public void ChangeStatusTest()
    {
        User shuvro = new User("shuvro");
        UserMediator userMediator = new UserMediator();

        IssueManager issueManager = new IssueManager(userMediator);

        Issue issue1 = new Issue("button round", "round the buttons", PRIORITY.LOW, STATUS.OPEN, shuvro);

        ICommand create_first_issue = new IssueCreateCommand(issueManager, issue1);
        create_first_issue.execute();

        ICommand change_status = new UpdateIssueStatusCommand(issueManager, issue1, STATUS.CLOSED);
        change_status.execute();

        Assert.Equal(STATUS.CLOSED, issue1.status);
    }
}