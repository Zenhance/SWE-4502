using TaskManager.Core;
using TaskManager.Model;

namespace TaskManager.Command;

public class IssueUpdayeAssigneeCommand
{
    private IssueManager issueManager;
    private Issue issue;
    private User oldAssignee;
    private User newAssignee;

    public IssueUpdayeAssigneeCommand(IssueManager issueManager, Issue issue, User oldAssignee, User newAssignee)
    {
        this.issueManager = issueManager;
        this.issue = issue;
        this.oldAssignee = oldAssignee;
        this.newAssignee = newAssignee;
    }
    
    public void execute()
    {
        issueManager.UpdateIssueAssignedTo(issue, newAssignee);
    }
    
    public void undo()
    {
        issueManager.UpdateIssueAssignedTo(issue, oldAssignee);
    }
}