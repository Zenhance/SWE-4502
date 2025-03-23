using TaskManager.Domain;

namespace TaskManager.Repository;

public class IssueRepository
{
    private readonly Dictionary<int, Issue> _issues = new();
    private int _nextIssueId = 1;
    private int _nextCommentId = 1;

    public int Add(Issue issue)
    {
        issue.Id = _nextIssueId++;
        issue.CreatedDate = DateTime.Now;
        issue.Status = IssueStatus.Open;
        _issues[issue.Id] = issue;
        return issue.Id;
    }

    public void Remove(int id)
    {
        _issues.Remove(id);
    }

    public void Update(Issue issue)
    {
        issue.LastModifiedDate = DateTime.Now;
        _issues[issue.Id] = issue;
    }

    public Issue GetById(int id)
    {
        return (_issues.TryGetValue(id, out var issue) ? issue.Clone() : null) ?? throw new InvalidOperationException();
    }

    public IEnumerable<Issue> GetAll()
    {
        return _issues.Values.Select(i => i.Clone());
    }

    public int AddComment(int issueId, Comment comment)
    {
        if (_issues.TryGetValue(issueId, out var issue))
        {
            comment.Id = _nextCommentId++;
            comment.CreatedDate = DateTime.Now;
            issue.Comments.Add(comment);
            issue.LastModifiedDate = DateTime.Now;
            return comment.Id;
        }
        throw new ArgumentException($"Issue with ID {issueId} not found");
    }

    public void RemoveComment(int issueId, int commentId)
    {
        if (_issues.TryGetValue(issueId, out var issue))
        {
            var comment = issue.Comments.FirstOrDefault(c => c.Id == commentId);
            if (comment != null)
            {
                issue.Comments.Remove(comment);
                issue.LastModifiedDate = DateTime.Now;
            }
        }
    }
}