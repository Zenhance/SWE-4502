using LabFinalTask.Log;
using LabFinalTask.Model;

namespace LabFinalTask.Command;

public class IssueCreateCommand : ICommand
{
    IssuePrototype issuePrototype;
    Issue issue;
    
    public IssueCreateCommand(Issue issue)
    {
        this.issuePrototype = issue.Log();
        this.issue = issue;
    }
    
    public IssueCreateCommand(){}
    
    public void execute()
    {
        // Will do later
    }
    
    public void undo()
    {
        if(issuePrototype != null)
        {
            issue.LoadFromLog(issuePrototype);
        }
    }
    
    
}