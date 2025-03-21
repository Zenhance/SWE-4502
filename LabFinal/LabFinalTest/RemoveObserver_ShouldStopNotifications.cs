using LabFinalTask.Command;
using LabFinalTask.Core;
using LabFinalTask.ENUM;
using LabFinalTask.Mediator;
using LabFinalTask.Model;

namespace LabFinal;

public class RemoveObserver_ShouldStopNotifications
{
    [Fact]
    public void removeObserverTest()
    {
        User shuvro = new User("shuvro");
        User rakin = new User("rakin");
        User mubeen = new User("mubeen");
        
        UserMediator userMediator = new UserMediator();
        userMediator.AddUser(rakin);
        userMediator.AddUser(mubeen);
        userMediator.AddUser(shuvro);

        IssueManager issueManager = new IssueManager(userMediator);

        Issue issue1 = new Issue("button round", "round the buttons", PRIORITY.LOW, STATUS.OPEN, shuvro);

        CommandManager commandManager = new CommandManager();
        
        ICommand create_first_issue = new IssueCreateCommand(issueManager, issue1);
        commandManager.ExecuteCommand(create_first_issue);
        
        userMediator.RemoveUser(rakin);
        
        ICommand changePriority = new IssuePriorityUpdateCommand(issueManager, issue1, PRIORITY.HIGH);
        commandManager.ExecuteCommand(changePriority);
        
        Assert.Equal(PRIORITY.HIGH, issue1.priority);
        
        string expected = "Issue priority updated: LOW -> HIGH";

        string expected_rakin = "New issue created: button round";
        
        Assert.Equal(expected, shuvro.lastEmail);
        Assert.Equal(expected, mubeen.lastEmail);
        
        
        Assert.Equal(expected_rakin, rakin.lastEmail);
    }
}