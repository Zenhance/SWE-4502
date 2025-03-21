using System;

public class IssueRepository
{
    private Dictionary<int, Issue> issues;

    public void AddIssue(Issue issue)
    {
        issues.Add(issue.ID, issue);
    }
    public void GetIssue(int ID)
    {
        return issues[ID];
    }
    public void UpdateIssue(Issue issue)
    {
        issues[issue.ID] = issue;
    }
}
