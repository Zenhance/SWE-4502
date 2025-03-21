namespace TaskManager.Domain;


public enum IssuePriority
{
    Low,
    Medium,
    High,
    Critical
}

public enum IssueStatus
{
    Open,
    InProgress,
    UnderReview,
    Resolved,
    Closed
}
public class Issue
{
    public int Id { get; set; }
    public string? Title { get; set; }
    public string? Description { get; set; }
    public IssuePriority Priority { get; set; }
    public IssueStatus Status { get; set; } = IssueStatus.Open;
    public DateTime CreationDate { get; set; }
    public DateTime LastModifiedDate { get; set; }
    public string? AssigendTo { get; set; }
    public HashSet<string> Tags { get; set; } = new();


}
