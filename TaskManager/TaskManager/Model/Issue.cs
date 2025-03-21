using TaskManager.ENUM;
using TaskManagerOriginal.ENUM;
using TaskManagerOriginal.Prototype;

namespace TaskManagerOriginal.Model;

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
    
    public Issue(string title, string description, PRIORITY priority, User assignedTo, STATUS status, DateTime createdDate, DateTime lastModifiedDate)
    {
        this.title = title;
        this.description = description;
        this.priority = priority;
        this.AssignedTo = assignedTo;
        this.status = status;
        this.createdDate = createdDate;
        this.lastModifiedDate = lastModifiedDate;
        this.comments = new List<Comment>();
    }

    public IssuePrototype CreateVersion()
    {
        IssuePrototype issuePrototype = new IssuePrototype(this.title, this.description, this.priority, this.AssignedTo, this.status, this.createdDate, this.lastModifiedDate);
        return issuePrototype;
    }

    public void LoadFromPrototype(IssuePrototype issuePrototype)
    {
        this.title = issuePrototype.title;
        this.description = issuePrototype.description;
        this.priority = issuePrototype.priority;
        this.status = issuePrototype.status;
        this.AssignedTo = issuePrototype.AssignedTo;
        this.createdDate = issuePrototype.createdDate;
        this.lastModifiedDate = issuePrototype.lastModifiedDate;
    }
    
    public void AddComment(Comment comment)
    {
        this.comments.Add(comment);
    }
    
    public void RemoveComment(Comment comment)
    {
        this.comments.Remove(comment);
    }
    
    public void AddTag(Tag tag)
    {
        this.tags.Add(tag);
    }





}