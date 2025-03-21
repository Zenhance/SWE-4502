using TaskManager.Core;
using TaskManager.ENUM;
using TaskManager.Model;

namespace TaskManager.Command;

public class IssuePriorityUpdateCommand:ICommand
{
    private IssueManager _issueManager;
    private Issue _issue;
    private IssuePriorityENUM _oldPriority;
    private IssuePriorityENUM _newPriority;

    public IssuePriorityUpdateCommand(IssueManager issueManager,Issue issue, IssuePriorityENUM oldPriority, IssuePriorityENUM newPriority)
    {
        _issueManager = issueManager;
        _issue = issue;
        _oldPriority = oldPriority;
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