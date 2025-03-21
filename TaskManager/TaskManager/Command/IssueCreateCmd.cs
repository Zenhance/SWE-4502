using TaskManagerOriginal.Model;
using TaskManagerOriginal.Prototype;

namespace TaskManagerOriginal.Command;

public class IssueCreateCmd : Icommand
{
    private IssueMan _issueManager;
    private Issue _issue;
    private IssuePrototype _issuePrototype;
    public IssueCreateCmd(IssueMan issueManager, Issue issue, IssuePrototype issuePrototype)
    {
        this._issueManager = issueManager;
        this._issue = issue;
        this._issuePrototype = issuePrototype;
            
    }

    

    
    
    
    
}