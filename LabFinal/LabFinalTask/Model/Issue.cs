using LabFinalTask.ENUM;

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
}