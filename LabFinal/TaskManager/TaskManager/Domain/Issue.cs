namespace TaskManager.Domain;

public class Issue : ICloneable<Issue>
{
    public int Id { get; set; }
    public string Title { get; set; }
    public string Description { get; set; }
    public IssuePriority Priority { get; set; }
    public IssueStatus Status { get; set; }
    public DateTime CreatedDate { get; set; }
    public DateTime? LastModifiedDate { get; set; }
    public string AssignedTo { get; set; }
    public List<string> Tags { get; set; } = [];
    public List<Comment> Comments { get; set; } = [];

    public Issue Clone()
    {
        return new Issue
        {
            Id = this.Id,
            Title = this.Title,
            Description = this.Description,
            Priority = this.Priority,
            Status = this.Status,
            CreatedDate = this.CreatedDate,
            LastModifiedDate = this.LastModifiedDate,
            AssignedTo = this.AssignedTo,
            Tags = new List<string>(this.Tags),
            Comments = this.Comments.Select(c => new Comment
            {
                Id = c.Id,
                Content = c.Content,
                Author = c.Author,
                CreatedDate = c.CreatedDate
            }).ToList()
        };
    }
}