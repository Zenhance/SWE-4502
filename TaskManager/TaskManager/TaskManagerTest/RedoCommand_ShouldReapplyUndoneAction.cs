using TaskManager.Command;
using TaskManager.Core;
using TaskManager.ENUM;
using TaskManager.Model;

namespace TaskManagerTest;

public class RedoCommand_ShouldReapplyUndoneAction
{
    [Test]
    public void TestRedoCommand()
    {
        User rayshad = new User("rayshad");
        UserMediator userMediator = new UserMediator();
        CommandManager commandManager = new CommandManager();
        
        IssueManager issueManager = new IssueManager(userMediator);
        
        Issue issue1 = new Issue("FILL BUTTON", "fILL BUTTON WITH BLUE COLOR", IssuePriorityENUM.LOW,
            IssueStatusENUM.OPEN, rayshad);
        
        ICommand create = new IssueCreateCommand(issueManager, issue1);
        
        commandManager.ExecuteCommand(create);

        ICommand changeStatus = new IssueUpdateStatusCommand(issueManager, issue1, IssueStatusENUM.CLOSED);
        commandManager.ExecuteCommand(changeStatus);
        
        Assert.AreEqual(IssueStatusENUM.CLOSED, issue1._status);
        
        commandManager.UndoCommand();
        
        Assert.AreEqual(IssueStatusENUM.OPEN, issue1._status);
        
        commandManager.RedoCommand();
        
        Assert.AreEqual(IssueStatusENUM.OPEN, issue1._status);
    }
}