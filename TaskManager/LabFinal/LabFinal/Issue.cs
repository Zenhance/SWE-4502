
namespace LabFinal;

public class Issue : ICloneable
{
    public int Id { get; set; }
    public string Title { get; set; }
    public string Description { get; set; }
    public Priority Priority { get; set; }
    public Status Status { get; set; }
    public DateTime CreationDate { get; set; }
    public DateTime LastModifiedDate { get; set; }
    public string AssignedTo { get; set; }
    public List<string> Tags { get; set; }
    public List<Comment> Comments { get; set; }

    public Issue(int id, string title, string description, Priority priority, string assignedTo)
    {
        Id = id;
        Title = title;
        Description = description;
        Priority = priority;
        Status = Status.Open;
        CreationDate = DateTime.Now;
        LastModifiedDate = DateTime.Now;
        AssignedTo = assignedTo;
        Tags = new List<string>();
        Comments = new List<Comment>();
    }

    public object Clone()
    {
        var clone = new Issue(Id, Title, Description, Priority, AssignedTo)
        {
            Status = Status,
            CreationDate = CreationDate,
            LastModifiedDate = LastModifiedDate,
            Tags = new List<string>(Tags),
            Comments = Comments.Select(c => new Comment(c.Id, c.Content, c.Author)).ToList()
        };
        return clone;
    }
}    