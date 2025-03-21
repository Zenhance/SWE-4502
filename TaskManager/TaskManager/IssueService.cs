using TaskManager.Domain;
using TaskManager.Repositories;

namespace TaskManager;

public class IssueService
{
    private IssueRepository _issueRepo = new();
    private CommentRepository _commentRepo = new();
    public Issue CreateIssue(Issue issue)
    {
        return _issueRepo.Create(issue);
    }

    public Issue? GetIssueById(int id)
    {
        return _issueRepo.FindById(id);
    }

    public Comment? AddComment(int issueId, Comment comment)
    {
        var issue = _issueRepo.FindById(issueId);
        if (issue == null) return null;
        comment = _commentRepo.Create(comment);
        issue.Comments.Add(comment);
        return comment;
    }

    public Comment? GetCommentById(int id)
    {
        return _commentRepo.FindById(id);
    }

    public Issue? UpdateIssueStatus(int issueId, IssueStatus status)
    {
        var issue = _issueRepo.FindById(issueId);
        if (issue == null) return null;
        issue.Status = status;
        return issue;
    }
}
