using TaskManager.Core;
using TaskManager.Model;

namespace TaskManager.Command;

public class IssueDescriptionUpdateCommand:ICommand
{
    private IssueManager _issueManager;
    private Issue _issue;
    private string _oldDescription;
    private string _newDescription;
    
    public IssueDescriptionUpdateCommand(IssueManager issueManager, Issue issue,string oldDescription, string newDescription)
    {
        _issueManager = issueManager;
        _issue = issue;
        _oldDescription = oldDescription;
        _newDescription = newDescription;
    }

    public void execute()
    {
        _issueManager.UpdateIssueDescription(_issue, _newDescription);
    }
    
    public void undo()
    {
        _issueManager.UpdateIssueDescription(_issue, _oldDescription);
    }
    
}