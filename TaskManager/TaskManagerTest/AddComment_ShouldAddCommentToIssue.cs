using TaskManager.Core;
using TaskManager.ENUM;
using TaskManager.Mediator;
using TaskManager.Model;
using TaskManager.Command;

namespace TaskManagerTest;
public class AddComment_ShouldAddCommentToIssue
{
    [Fact]
    public void AddCommentTest()
    {
        User Abrar = new User("Abrar");
        UserMediator userMediator = new UserMediator();

        IssueManager issueManager = new IssueManager(userMediator);

        Issue issue1 = new Issue("button round", "round the buttons", PRIORITY.LOW, STATUS.OPEN,Abrar );
        
        ICommand create_first_issue = new IssueCreateCommand(issueManager, issue1);
        create_first_issue.execute();
        
        Comment comment = new Comment("This is a comment", Abrar);
        
        ICommand create_comment_command = new CreateCommentCommand(issueManager, issue1, comment);
        create_comment_command.execute();
        
        Assert.Equal(comment, issueManager.issues[0].comments[0]);
    }
}