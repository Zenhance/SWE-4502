using LabFinalTask.Core;
using LabFinalTask.Log;
using LabFinalTask.Model;

namespace LabFinalTask.Command;

public class IssueCreateCommand : ICommand
{
    private IssueManager _issueManager;
    private Issue _issue;
    private IssuePrototype _issuePrototype;
    
    public IssueCreateCommand(IssueManager issueManager)
    {
        _issueManager = issueManager;
    }

    public void execute()
    {
        
    }

    public void undo()
    {
        
    }

}