using LabFinalTask.Core;
using LabFinalTask.Model;

namespace LabFinalTask.Command;

public class CreateCommentCommand : ICommand
{
    private IssueManager _issueManager;
    private Issue _issue;
    private Comment _comment;
    
    public CreateCommentCommand(IssueManager issueManager, Issue issue, Comment comment)
    {
        _issueManager = issueManager;
        _issue = issue;
        _comment = comment;
    }

    public void execute()
    {
        _issueManager.AddIssueComment(_issue, _comment);
    }

    public void undo()
    {
        _issueManager.AddIssueComment(_issue, _comment);
    }

}