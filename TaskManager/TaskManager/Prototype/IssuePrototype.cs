using TaskManager.ENUM;
using TaskManagerOriginal.ENUM;
using TaskManagerOriginal.Model;

namespace TaskManagerOriginal.Prototype;

public class IssuePrototype
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
    
    public IssuePrototype(string title, string description, PRIORITY priority, User assignedTo, STATUS status, DateTime createdDate, DateTime lastModifiedDate)
    {
        this.title = title;
        this.description = description;
        this.priority = priority;
        this.AssignedTo = assignedTo;
        this.status = status;
        this.createdDate = createdDate;
        this.lastModifiedDate = lastModifiedDate;
        this.comments = new List<Comment>();
        this.tags = new List<Tag>();
    }
    
    
}