using TaskManagerOriginal.Model;

namespace TaskManagerOriginal.Command;

public class IssueCreateCmd : Icommand
{
    IssueMan issueManager;
    private Issue _issue;
    public IssueCreateCmd(IssueMan issueManager, Issue issue)
    {
        this.issueManager = issueManager;
        this._issue = issue;
    }
    
}