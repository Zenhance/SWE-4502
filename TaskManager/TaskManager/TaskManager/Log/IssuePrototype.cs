using TaskManager.ENUM;
using TaskManager.Model;

namespace TaskManager.Prototype;

public class IssuePrototype
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


    public IssuePrototype(string title, string description,IssuePriorityENUM priority, IssueStatusENUM status , DateTime createdDate, DateTime updatedDate, User assignedTo, List<Tag> tags, List<Comment> comments)
    {
        _title = title;
        _description = description;
        _priority = priority;
        _status = status;
        _createdDate = createdDate;
        _updatedDate = updatedDate;
        _assignedTo = assignedTo;
        _tags = tags;
        _comments = comments;
    }
}