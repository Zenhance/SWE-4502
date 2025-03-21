using TaskManagerOriginal.Model;

namespace TaskManagerOriginal.Command;

public class CreateTagCommand
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

    public void execute()
    {
        _issueManager.AddTagToIssue(_issue, _tag);
    }

    public void undo()
    {
        _issueManager.AddTagToIssue(_issue, _tag);
    }
}