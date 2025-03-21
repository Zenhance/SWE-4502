using TaskManager.Model;

namespace TaskManager.Core;

public class IssueManager
{
    public List<Issue> _issues;

    public IssueManager()
    {
        _issues = new List<Issue>();
    }

    public void AddIssue(Issue issue)
    {
        _issues.Add(issue);
    }
    
    public void RemoveIssue(Issue issue)
    {
        _issues.Remove(issue);
    }
}