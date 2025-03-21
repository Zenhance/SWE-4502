using LabFinalTask.Core;
using LabFinalTask.Log;
using LabFinalTask.Model;

namespace LabFinalTask.Command;

public class IssueCreateCommand : ICommand
{
    private IssueManager _issueManager;
    private Issue _issue;
    private IssuePrototype _issuePrototype;
    
    public IssueCreateCommand(IssueManager issueManager, Issue issue)
    {
        _issueManager = issueManager;
        _issue = issue;
    }

    public void execute()
    {
        _issuePrototype = _issue.Log();
        _issueManager.AddIssue(_issue);
    }

    public void undo()
    {
        _issueManager.RemoveIssue(_issue);
    }

}