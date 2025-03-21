using TaskManager.Command;
using TaskManager.Core;
using TaskManager.ENUM;
using TaskManager.Mediator;
using TaskManager.Model;

namespace TaskManager;

public class StatisticsCollector_ShouldTrackCommandCounts
{
    [Fact]
    public void CommandCountTest()
    {
        User Abrar = new User("Abrar");
        UserMediator userMediator = new UserMediator();

        IssueManager issueManager = new IssueManager(userMediator);

        Issue issue1 = new Issue("button round", "round the buttons", PRIORITY.LOW, STATUS.OPEN, Abrar);

        CommandManager commandManager = new CommandManager();
        
        ICommand create_first_issue = new IssueCreateCommand(issueManager, issue1);
        commandManager.ExecuteCommand(create_first_issue);
        
        ICommand changePriority = new IssuePriorityUpdateCommand(issueManager, issue1, PRIORITY.HIGH);
        commandManager.ExecuteCommand(changePriority);
        
        ICommand addComment = new CreateCommentCommand(issueManager, issue1, new Comment("This is a comment", Abrar));
        commandManager.ExecuteCommand(addComment);
        
        Assert.Equal(3, commandManager.GetCommandCount());
    }
}