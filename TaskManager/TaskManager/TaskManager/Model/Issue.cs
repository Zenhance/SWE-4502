using TaskManager.ENUM;
using TaskManager.Prototype;

namespace TaskManager.Model;

public class Issue
{
    private int _id;
    private string _title;
    private string _description;
    private IssuePriorityENUM _priority;
    private IssueStatusENUM _status;
    private DateTime _createdDate;
    private DateTime _updatedDate;
    private User _assignedTo;
    private List<Tag> _tags;
    private List<Comment> _comments;
    
    public Issue(int id, string title, string description, IssuePriorityENUM priority, IssueStatusENUM status, User assignedTo, List<Tag> tags, List<Comment> comments)
    {
        _id = id;
        _title = title;
        _description = description;
        _priority = priority;
        _status = status;
        _createdDate = DateTime.Now;
        _updatedDate = DateTime.Now;
        _assignedTo = assignedTo;
        _tags = tags;
        _comments = comments;
    }

    public IssuePrototype Log()
    {
        IssuePrototype isp = new IssuePrototype(_title, _description, _priority, _status, _assignedTo, _tags, _comments);
        
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