using TaskManager.Core;
using TaskManager.Model;
using TaskManager.Prototype;

namespace TaskManager.Command;

public class IssueCreateCommand:ICommand
{
    private IssuePrototype _issuePrototype;
    private Issue _issue;
    private IssueManager _issueManager;

    public IssueCreateCommand(IssueManager issueManager, Issue issue)
    {
        _issueManager = issueManager;
        _issue = issue;
    }

    public void execute()
    {
        _issuePrototype = _issue.Log();
        _issueManager.AddIssue(_issue);
    }

    public void undo()
    {
        _issueManager.RemoveIssue(_issue);
    }
}