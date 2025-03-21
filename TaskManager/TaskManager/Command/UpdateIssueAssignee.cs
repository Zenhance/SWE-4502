using TaskManagerOriginal.Model;

namespace TaskManagerOriginal.Command;

public class UpdateIssueAssignee
{
    private IssueMan _issueManager;
    private Issue _issue;
    private User _oldAssignee;
    private User _newAssignee;
    
    public UpdateIssueAssignee(IssueMan issueManager, Issue issue, User newAssignee)
    {
        _issueManager = issueManager;
        _issue = issue;
        _oldAssignee = issue.AssignedTo;
        _newAssignee = newAssignee;
    }

    
    public void Execute()
    {
        _issueManager.UpdateIssueAssignedTo(_issue, _newAssignee);
    }
    
    public void Undo()
    {
        _issueManager.UpdateIssueAssignedTo(_issue, _oldAssignee);
    }
    
    
}