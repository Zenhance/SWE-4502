//Issue Model
using TaskManager.ENUM;
using TaskManager.Log;

namespace TaskManager.Model;

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
    
    public Issue(string title, string description, PRIORITY priority, STATUS status, DateTime createdDate,
        DateTime lastModifiedDate, User AssignedTo)
    {
        this.title = title;
        this.description = description;
        this.priority = priority;
        this.status = status;
        this.createdDate = createdDate;
        this.lastModifiedDate = lastModifiedDate;
        this.AssignedTo = AssignedTo;
    }

    public IssuePrototype Log()
    {
        IssuePrototype issuePrototype = new IssuePrototype(
            title, description, priority, status, createdDate, lastModifiedDate, AssignedTo
        );

        return issuePrototype;
    }
    
}