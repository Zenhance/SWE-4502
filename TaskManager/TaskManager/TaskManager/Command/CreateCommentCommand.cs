using TaskManager.Core;
using TaskManager.Model;

namespace TaskManager.Command;

public class CreateCommentCommand:ICommand
{
    private IssueManager issueManager;
    private Issue issue;
    private Comment comment;
    
    public CreateCommentCommand(IssueManager issueManager, Issue issue, Comment comment)
    {
        this.issueManager = issueManager;
        this.issue = issue;
        this.comment = comment;
    }

    public void execute()
    {
        issueManager.AddIssueComment(issue, comment);
    }
    
    public void undo()
    {
        issueManager.AddIssueComment(issue, comment);
    }
    
    
}