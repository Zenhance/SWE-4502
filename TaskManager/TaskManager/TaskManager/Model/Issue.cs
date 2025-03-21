using TaskManager.ENUM;
using TaskManager.Prototype;

namespace TaskManager.Model;

public class Issue
{
    public int _id;
    public string _title;
    public string _description;
    public IssuePriorityENUM _priority;
    public IssueStatusENUM _status;
    public DateTime _createdDate;
    public DateTime _updatedDate;
    public User _assignedTo;
    public List<Tag> _tags;
    public List<Comment> _comments;
    
    public Issue(string title, string description, IssuePriorityENUM priority, IssueStatusENUM status, User assignedTo)
    {
        _title = title;
        _description = description;
        _priority = priority;
        _status = status;
        _createdDate = DateTime.Now;
        _updatedDate = DateTime.Now;
        _assignedTo = assignedTo;
    }

    public IssuePrototype Log()
    {
        IssuePrototype isp = new IssuePrototype(_title, _description, _priority, _status, _createdDate, _updatedDate, _assignedTo, _tags, _comments);
        
        return isp;
    }

    public void AddComment(Comment comment)
    {
        _comments.Add(comment);
    }
    
    public void AddTag(Tag tag)
    {
        _tags.Add(tag);
    }

    public void LoadFromLog(IssuePrototype _issuePrototype)
    {
        _title = _issuePrototype._title;
        _description = _issuePrototype._description;
        _priority = _issuePrototype._priority;
        _status = _issuePrototype._status;
        _createdDate = _issuePrototype._createdDate;
        _updatedDate = DateTime.Now;
        _assignedTo = _issuePrototype._assignedTo;
    }
}