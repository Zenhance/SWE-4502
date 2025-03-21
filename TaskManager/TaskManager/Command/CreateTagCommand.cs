using System.Data;
using TaskManagerOriginal.Model;

namespace TaskManagerOriginal.Command;

public class CreateTagCommand : Icommand
{
    private IssueMan _issueManager;
    private Issue _issue;
    private Tag _tag;
    
    public CreateTagCommand(IssueMan issueManager, Issue issue, Tag tag)
    {
        _issueManager = issueManager;
        _issue = issue;
        _tag = tag;
    }

    public void Execute()
    {
        _issueManager.AddTagToIssue(_issue, _tag);
    }

    public void Undo()
    {
        _issueManager.AddTagToIssue(_issue, _tag);
    }
}