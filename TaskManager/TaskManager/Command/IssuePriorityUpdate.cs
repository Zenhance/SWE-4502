using TaskManager.ENUM;
using TaskManagerOriginal.Model;

namespace TaskManagerOriginal.Command;

public class IssuePriorityUpdate:Icommand
{
    IssueMan _issueManager;
    Issue _issue;
    private PRIORITY _priority;
    private PRIORITY _oldPriority;
    
    public IssuePriorityUpdate(IssueMan issueManager, Issue issue, PRIORITY priority)
    {
        this._issueManager = issueManager;
        this._issue = issue;
        this._priority = priority;
        this._oldPriority = issue.priority;
    }
    
    public void Execute()
    {
        this._issueManager.UpdateIssuePriority(this._issue, this._priority);
    }
    
    public void Undo()
    {
        this._issueManager.UpdateIssuePriority(this._issue, this._oldPriority);
    }
    
}