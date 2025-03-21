using TaskManager.Command;
using TaskManager.Core;
using TaskManager.ENUM;
using TaskManager.Mediator;
using TaskManager.Model;

namespace TaskManager;

public class RedoCommand_ShouldReapplyUndoneAction
{
    [Fact]
    public void RedoCommandTest()
    {
        User Abrar = new User("Abrar");
        UserMediator userMediator = new UserMediator();

        IssueManager issueManager = new IssueManager(userMediator);
        CommandManager commandManager = new CommandManager();

        Issue issue1 = new Issue("button round", "round the buttons", PRIORITY.LOW, STATUS.OPEN, Abrar);

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