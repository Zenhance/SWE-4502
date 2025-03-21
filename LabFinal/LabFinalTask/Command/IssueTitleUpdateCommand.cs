using LabFinalTask.Core;
using LabFinalTask.Model;

namespace LabFinalTask.Command;

public class IssueTitleUpdateCommand : ICommand
{
    private IssueManager _issueManager;
    private Issue _issue;
    private string _oldTitle;
    private string _newTitle;
    
    public IssueTitleUpdateCommand(IssueManager issueManager, Issue issue, string newTitle)
    {
        _issueManager = issueManager;
        _issue = issue;
        _oldTitle = issue.title;
        _newTitle = newTitle;
    }

    public void execute()
    {
        _issueManager.UpdateIssueTitle(_issue, _newTitle);
    }

    public void undo()
    {
        _issueManager.UpdateIssueTitle(_issue, _oldTitle);
    }
    
}