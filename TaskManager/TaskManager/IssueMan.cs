using TaskManager.ENUM;
using TaskManagerOriginal.ENUM;
using TaskManagerOriginal.Model;

namespace TaskManagerOriginal;

public class IssueMan
{
    public List<Issue> issues;
    public Mediate mediator;

    public IssueMan()
    {
        issues = new List<Issue>();
        mediator = new Mediate();
    }

    public void AddIssue(Issue issue)
    {
        issues.Add(issue);
    }

    public void RemoveIssue(Issue issue)
    {
        issues.Remove(issue);
    }

    public void UpdateIssueTitle(Issue issue, string title)
    {
        issue.title = title;
    }
    
    public void UpdateIssueDescription(Issue issue, string description)
    {
        issue.description = description;
    }
    
    public void UpdateIssuePriority(Issue issue, PRIORITY priority)
    {
        issue.priority = priority;
    }
    
    public void UpdateIssueStatus(Issue issue, STATUS status)
    {
        issue.status = status;
    }
    
    public void UpdateIssueAssignedTo(Issue issue, User user)
    {
        issue.AssignedTo = user;
    }
    
    public void AddCommentToIssue(Issue issue, Comment comment)
    {
        issue.AddComment(comment);
    }
    
    public void RemoveCommentFromIssue(Issue issue, Comment comment)
    {
        issue.RemoveComment(comment);
    }
    
    public void AddTagToIssue(Issue issue, Tag tag)
    {
        issue.AddTag(tag);
    }
}