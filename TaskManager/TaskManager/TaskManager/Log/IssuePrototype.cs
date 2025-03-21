using TaskManager.ENUM;
using TaskManager.Model;

namespace TaskManager.Prototype;

public class IssuePrototype
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

    public IssuePrototype(string title, string description,IssuePriorityENUM priority, IssueStatusENUM status, User assignedTo, List<Tag> tags, List<Comment> comments)
    {
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
}