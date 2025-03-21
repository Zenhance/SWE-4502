using LabFinalTask.Command;
using LabFinalTask.Core;
using LabFinalTask.ENUM;
using LabFinalTask.Mediator;
using LabFinalTask.Model;

namespace LabFinal;

public class RedoCommand_ShouldReapplyUndoneAction
{
    [Fact]
    public void RedoCommandTest()
    {
        User shuvro = new User("shuvro");
        UserMediator userMediator = new UserMediator();

        IssueManager issueManager = new IssueManager(userMediator);
        CommandManager commandManager = new CommandManager();

        Issue issue1 = new Issue("button round", "round the buttons", PRIORITY.LOW, STATUS.OPEN, shuvro);

        ICommand create_first_issue = new IssueCreateCommand(issueManager, issue1);
        commandManager.ExecuteCommand(create_first_issue);
        
        ICommand changeStatusCommand = new UpdateIssueStatusCommand(issueManager, issue1, STATUS.CLOSED);
        commandManager.ExecuteCommand(changeStatusCommand);
        
        Assert.Equal(STATUS.CLOSED, issue1.status);
        
        commandManager.UndoCommand();
        
        Assert.Equal(STATUS.OPEN, issue1.status);
        
        commandManager.RedoCommand();
        
        Assert.Equal(STATUS.CLOSED, issue1.status);
    }
}