using LabFinalTask.Core;
using LabFinalTask.ENUM;
using LabFinalTask.Mediator;
using LabFinalTask.Model;
using LabFinalTask.Command;

namespace LabFinal;

public class AddComment_ShouldAddCommentToIssue
{
    [Fact]
    public void AddCommentTest()
    {
        User shuvro = new User("shuvro");
        UserMediator userMediator = new UserMediator();

        IssueManager issueManager = new IssueManager(userMediator);

        Issue issue1 = new Issue("button round", "round the buttons", PRIORITY.LOW, STATUS.OPEN, shuvro);
        
        ICommand create_first_issue = new IssueCreateCommand(issueManager, issue1);
        create_first_issue.execute();
        
        Comment comment = new Comment("This is a comment", shuvro);
        
        ICommand create_comment_command = new CreateCommentCommand(issueManager, issue1, comment);
        create_comment_command.execute();
        
        Assert.Equal(comment, issueManager.issues[0].comments[0]);
    }
}