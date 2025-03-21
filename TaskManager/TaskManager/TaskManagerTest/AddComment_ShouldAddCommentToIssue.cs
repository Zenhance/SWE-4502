using TaskManager.Command;
using TaskManager.Core;
using TaskManager.ENUM;
using TaskManager.Model;

namespace TaskManagerTest;

public class AddComment_ShouldAddCommentToIssue
{
    [Test]
    public void TestAddCommente()
    {
        User rayshad = new User("rayshad");
        UserMediator userMediator = new UserMediator();
        
        IssueManager issueManager = new IssueManager(userMediator);
        
        Issue issue1 = new Issue("FILL BUTTON", "fILL BUTTON WITH BLUE COLOR", IssuePriorityENUM.LOW,
            IssueStatusENUM.OPEN, rayshad);
        
        ICommand create = new IssueCreateCommand(issueManager, issue1);
        
        create.execute();

        Comment comment = new Comment("You should work properly", rayshad);
        
        ICommand addComment = new CreateCommentCommand(issueManager, issue1, comment);
        addComment.execute();
        
        Assert.AreEqual(comment, issueManager._issues[0]._comments[0]);
    }
}