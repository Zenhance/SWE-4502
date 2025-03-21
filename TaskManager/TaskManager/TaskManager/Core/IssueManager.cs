using TaskManager.ENUM;
using TaskManager.Model;

namespace TaskManager.Core;

public class IssueManager
{
    public List<Issue> _issues;
    public UserMediator _userMediator;

    public IssueManager(UserMediator userMediator)
    {
        _issues = new List<Issue>();
        _userMediator = userMediator;
    }

    public void AddIssue(Issue issue)
    {
        _issues.Add(issue);
        _userMediator.AddUser(issue._assignedTo);
        _userMediator.NotifyUsers("Issue created: " + issue._title);
    }
    
    public void RemoveIssue(Issue issue)
    {
        _issues.Remove(issue);
        _userMediator.NotifyUsers("Issue removed: " + issue._title);
    }

    public void UpdateIssueTitle(Issue issue, string title)
    {
        string oldTitle = issue._title;
        issue._title = title;
        _userMediator.NotifyUsers("Issue Title updated: " + oldTitle + " -> " + title);
    }
    
    public void UpdateIssueDescription(Issue issue, string description)
    {
        string oldDescription = issue._description;
        issue._description = description;
        _userMediator.NotifyUsers("Issue Description updated: " + oldDescription + " -> " + description);
    }
    
    public void UpdateIssuePriority(Issue issue, IssuePriorityENUM priority)
    {
        IssuePriorityENUM oldPriority = issue._priority;
        issue._priority = priority;
        _userMediator.NotifyUsers("Issue Priority updated: " + oldPriority + " -> " + priority);
    }

    public void UpdateIssueStatus(Issue issue, IssueStatusENUM status)
    {
        IssueStatusENUM oldStatus = issue._status;
        issue._status = status;
        _userMediator.NotifyUsers("Issue Status updated: " + oldStatus + " -> " + status);
    }
    
    public void UpdateIssueAssignedTo(Issue issue, User user)
    {
        User oldUser = issue._assignedTo;
        issue._assignedTo = user;
        _userMediator.NotifyUsers("Issue AssignedTo updated: " + oldUser + " -> " + user);
    }
    
    public void AddIssueComment(Issue issue, Comment comment)
    {
        issue._comments.Add(comment);
        _userMediator.NotifyUsers("Comment added to Issue: " + issue._title);
    }
    
    public void AddIssueTag(Issue issue, Tag tag)
    {
        issue._tags.Add(tag);
        _userMediator.NotifyUsers("Tag added to Issue: " + issue._title);
    }
}