using TaskManager.Core;
using TaskManager.Model;

namespace TaskManager.Command;

public class IssueUpdateTitleCommand:ICommand
{
    private IssueManager issueManager;
    private Issue issue;
    private string oldTitle;
    private string newTitle;
    
    public IssueUpdateTitleCommand(IssueManager issueManager, Issue issue, string oldTitle, string newTitle)
    {
        this.issueManager = issueManager;
        this.issue = issue;
        this.oldTitle = oldTitle;
        this.newTitle = newTitle;
    }
    
    public void execute()
    {
        issueManager.UpdateIssueTitle(issue, newTitle);
    }
    
    public void undo()
    {
        issueManager.UpdateIssueTitle(issue, oldTitle);
    }
}