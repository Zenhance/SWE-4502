using LabFinalTask.Model;

namespace LabFinalTask.Core;

public class IssueManager
{
    public List<Issue> issues;
    
    public IssueManager()
    {
        issues = new List<Issue>();
    }

    public void AddIssue(Issue issue)
    {
        issues.Add(issue);
    } 
    
    public void RemoveIssue(Issue issue)
    {
        issues.Remove(issue);
    }
}