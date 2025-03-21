using TaskManager.Core;
using TaskManager.ENUM;
using TaskManager.Model;

namespace TaskManager.Command;

public class IssuePriorityUpdateCommand : ICommand
{
    private IssueManager _issueManager;
    private Issue _issue;
    private PRIORITY _oldPriority;
    private PRIORITY _newPriority;
    
    public IssuePriorityUpdateCommand(IssueManager issueManager, Issue issue, PRIORITY newPriority)
    {
        _issueManager = issueManager;
        _issue = issue;
        _oldPriority = issue.priority;
        _newPriority = newPriority;
    }

    public void execute()
    {
        _issueManager.UpdateIssuePriority(_issue, _newPriority);
    }

    public void undo()
    {
        _issueManager.UpdateIssuePriority(_issue, _oldPriority);
    }
    
}