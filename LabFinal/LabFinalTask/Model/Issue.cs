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
    
    public List<Comment> comments;
    public List<Tag> tags;
    
    public Issue(string title, string description, PRIORITY priority, STATUS status, User AssignedTo)
    {
        this.title = title;
        this.description = description;
        this.priority = priority;
        this.status = status;
        this.createdDate = DateTime.Now;
        this.lastModifiedDate = DateTime.Now;
        this.AssignedTo = AssignedTo;
        
        comments = new List<Comment>();
        tags = new List<Tag>();
    }

    public IssuePrototype Log()
    {
        IssuePrototype issuePrototype = new IssuePrototype(
            title, description, priority, status, createdDate, lastModifiedDate, AssignedTo
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
    }
    
    public void AddComment(Comment comment)
    {
        comments.Add(comment);
    }
    
    public void AddTag(Tag tag)
    {
        tags.Add(tag);
    }
    
}

