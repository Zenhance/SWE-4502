using TaskManager.Core;
using TaskManager.ENUM;
using TaskManager.Model;

namespace TaskManager.Command;

public class IssueUpdateStatusCommand:ICommand
{
    private IssueManager _issueManager;
    private Issue _issue;
    private IssueStatusENUM _oldStatus;
    private IssueStatusENUM _newStatus;
    
    public IssueUpdateStatusCommand(IssueManager issueManager, Issue issue, IssueStatusENUM newStatus)
    {
        _issueManager = issueManager;
        _issue = issue;
        _newStatus = newStatus;
    }
    
    public void execute()
    {
        _issueManager.UpdateIssueStatus(_issue, _newStatus);
    }
    
    public void undo()
    {
        _issueManager.UpdateIssueStatus(_issue, _oldStatus);
    }
}