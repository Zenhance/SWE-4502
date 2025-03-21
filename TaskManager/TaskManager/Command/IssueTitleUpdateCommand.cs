using TaskManagerOriginal.Model;

namespace TaskManagerOriginal.Command;

public class IssueTitleUpdateCommand:Icommand
{
    private IssueMan _issueManager;
    private Issue _issue;
    private string _oldTitle;
    private string _newTitle;
    
    public IssueTitleUpdateCommand(IssueMan issueManager, Issue issue, string newTitle)
    {
        _issueManager = issueManager;
        _issue = issue;
        _oldTitle = issue.title;
        _newTitle = newTitle;
    }

    public void Execute()
    {
        _issueManager.UpdateIssueTitle(_issue, _newTitle);
    }

    public void Undo()
    {
        _issueManager.UpdateIssueTitle(_issue, _oldTitle);
    }
    
}