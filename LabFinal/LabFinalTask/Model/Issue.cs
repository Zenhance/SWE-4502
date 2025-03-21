using LabFinalTask.ENUM;
using LabFinalTask.Log;
using LabFinalTask.Mediator;

namespace LabFinalTask.Model;

public class Issue
{
    public int id;
    public string title;
    public string description;
    public PRIORITY priority;
    public STATUS status;
    public DateTime createdDate;
    public DateTime lastModifiedDate;
    public User AssignedTo;

    public UserMediator UserMediator;
    
    public List<Comment> comments;
    public List<Tag> tags;
    
    public Issue(string title, string description, PRIORITY priority, STATUS status, DateTime createdDate,
        DateTime lastModifiedDate, User AssignedTo, UserMediator UserMediator)
    {
        this.title = title;
        this.description = description;
        this.priority = priority;
        this.status = status;
        this.createdDate = createdDate;
        this.lastModifiedDate = lastModifiedDate;
        this.AssignedTo = AssignedTo;
        this.UserMediator = UserMediator;
        
        UserMediator.AddUser(this.AssignedTo);
        UserMediator.NotifyUsers("New Issue: " + title);
    }

    public IssuePrototype Log()
    {
        IssuePrototype issuePrototype = new IssuePrototype(
            title, description, priority, status, createdDate, lastModifiedDate, AssignedTo, UserMediator
        );

        return issuePrototype;
    }
    
    public void LoadFromLog(IssuePrototype issuePrototype)
    {
        title = issuePrototype.title;
        description = issuePrototype.description;
        priority = issuePrototype.priority;
        status = issuePrototype.status;
        createdDate = issuePrototype.createdDate;
        lastModifiedDate = issuePrototype.lastModifiedDate;
        AssignedTo = issuePrototype.AssignedTo;
        UserMediator = issuePrototype.UserMediator;
        
        UserMediator.NotifyUsers("Issue: " + title + " has been updated");
    }
    
    public void AddComment(Comment comment)
    {
        comments.Add(comment);
        UserMediator.NotifyUsers("New Comment: " + comment.content);
    }
    
    public void AddTag(Tag tag)
    {
        tags.Add(tag);
        UserMediator.NotifyUsers("New Tag: " + tag.name);
    }
    
}

