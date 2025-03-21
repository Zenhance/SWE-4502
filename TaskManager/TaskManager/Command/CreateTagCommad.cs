using TaskManager.Core;
using TaskManager.Model;

namespace TaskManager.Command;

public class CreateTagCommand
{
    private IssueManager _issueManager;
    private Issue _issue;
    private Tag _tag;
    
    public CreateTagCommand(IssueManager issueManager, Issue issue, Tag tag)
    {
        _issueManager = issueManager;
        _issue = issue;
        _tag = tag;
    }

    public void execute()
    {
        _issueManager.AddIssueTag(_issue, _tag);
    }

    public void undo()
    {
        _issueManager.AddIssueTag(_issue, _tag);
    }
}