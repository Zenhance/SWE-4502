using TaskManagerOriginal.Model;

namespace TaskManagerOriginal.Command;

public class IssueDescriptionUpdateCmd
{
    private IssueMan _issueManager;
    private Issue _issue;
    private string _description;
    private string _oldDescription;
    
    public IssueDescriptionUpdateCmd(IssueMan issueManager, Issue issue, string description)
    {
        this._issueManager = issueManager;
        this._issue = issue;
        this._description = description;
        this._oldDescription = issue.description;
    }
}