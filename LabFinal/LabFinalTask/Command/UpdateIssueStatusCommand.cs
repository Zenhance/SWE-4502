using LabFinalTask.Core;
using LabFinalTask.ENUM;
using LabFinalTask.Model;

namespace LabFinalTask.Command;

public class UpdateIssueStatusCommand : ICommand
{
    private IssueManager _issueManager;
    private Issue _issue;
    private STATUS _oldStatus;
    private STATUS _newStatus;
    
    public UpdateIssueStatusCommand(IssueManager issueManager, Issue issue, STATUS newStatus)
    {
        _issueManager = issueManager;
        _issue = issue;
        _oldStatus = issue.status;
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