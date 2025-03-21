using LabFinalTask.ENUM;
using LabFinalTask.Mediator;
using LabFinalTask.Model;

namespace LabFinalTask.Core;

public class IssueManager
{
    public List<Issue> issues;
    public UserMediator UserMediator;
    
    public IssueManager(UserMediator userMediator)
    {
        issues = new List<Issue>();
        UserMediator = userMediator;
    }

    public void AddIssue(Issue issue)
    {
        issues.Add(issue);
        UserMediator.NotifyUsers("New issue created: " + issue.title);
    } 
    
    public void RemoveIssue(Issue issue)
    {
        issues.Remove(issue);
        UserMediator.NotifyUsers("Issue removed: " + issue.title);
    }
    
    public void UpdateIssueTitle(Issue issue, string title)
    {
        string oldTitle = issue.title;
        issue.title = title;
        UserMediator.NotifyUsers("Issue title updated: " + oldTitle + " -> " + title);
    }
    
    public void UpdateIssueDescription(Issue issue, string description)
    {
        string oldDescription = issue.description;
        issue.description = description;
        UserMediator.NotifyUsers("Issue description updated: " + oldDescription + " -> " + description);
    }
    
    public void UpdateIssuePriority(Issue issue, PRIORITY priority)
    {
        PRIORITY oldPriority = issue.priority;
        issue.priority = priority;
        UserMediator.NotifyUsers("Issue priority updated: " + oldPriority + " -> " + priority);
    }
    
    public void UpdateIssueStatus(Issue issue, STATUS status)
    {
        STATUS oldStatus = issue.status;
        issue.status = status;
        UserMediator.NotifyUsers("Issue status updated: " + oldStatus + " -> " + status);
    }
    
    public void UpdateIssueAssignedTo(Issue issue, User user)
    {
        User oldUser = issue.AssignedTo;
        issue.AssignedTo = user;
        UserMediator.NotifyUsers("Issue assigned to updated: " + oldUser + " -> " + user);
    }
    
    public void AddIssueComment(Issue issue, Comment comment)
    {
        issue.AddComment(comment);
        UserMediator.NotifyUsers("New comment added to issue: " + issue.title);
    }
    
    public void AddIssueTag(Issue issue, Tag tag)
    {
        issue.AddTag(tag);
        UserMediator.NotifyUsers("New tag added to issue: " + issue.title);
    }
}