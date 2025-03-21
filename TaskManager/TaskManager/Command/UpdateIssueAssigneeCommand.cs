using TaskManager.Core;
using TaskManager.ENUM;
using TaskManager.Model;

namespace TaskManager.Command;

public class UpdateIssueAssigneeCommand : ICommand
{
    private IssueManager _issueManager;
    private Issue _issue;
    private User _oldAssignee;
    private User _newAssignee;
    
    public UpdateIssueAssigneeCommand(IssueManager issueManager, Issue issue, User newAssignee)
    {
        _issueManager = issueManager;
        _issue = issue;
        _oldAssignee = issue.AssignedTo;
        _newAssignee = newAssignee;
    }

    public void execute()
    {
        _issueManager.UpdateIssueAssignee(_issue, _newAssignee);
    }

    public void undo()
    {
        _issueManager.UpdateIssueAssignee(_issue, _oldAssignee);
    }
    
}