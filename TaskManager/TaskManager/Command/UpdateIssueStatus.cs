using TaskManagerOriginal.ENUM;
using TaskManagerOriginal.Model;

namespace TaskManagerOriginal.Command;

public class UpdateIssueStatus: Icommand
{
    private IssueMan _issueManager;
    private Issue _issue;
    private STATUS _oldStatus;
    private STATUS _newStatus;
    
    public UpdateIssueStatus(IssueMan issueManager, Issue issue, STATUS newStatus)
    {
        _issueManager = issueManager;
        _issue = issue;
        _oldStatus = issue.status;
        _newStatus = newStatus;
    }

    public void Execute()
    {
        _issueManager.UpdateIssueStatus(_issue, _newStatus);
    }

    public void Undo()
    {
        _issueManager.UpdateIssueStatus(_issue, _oldStatus);
    }
    
}