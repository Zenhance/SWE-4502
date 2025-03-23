using TaskManager.Domain;
using TaskManager.Repository;

namespace TaskManager.Commands;

public class ChangeIssueStatusCommand : ICommand
{
    private readonly IssueRepository _repository;
    private readonly int _issueId;
    private readonly IssueStatus _newStatus;
    private IssueStatus _oldStatus;

    public ChangeIssueStatusCommand(IssueRepository repository, int issueId, IssueStatus newStatus)
    {
        _repository = repository;
        _issueId = issueId;
        _newStatus = newStatus;
        Timestamp = DateTime.Now;
    }

    public void Execute()
    {
        var issue = _repository.GetById(_issueId);
        _oldStatus = issue.Status;
        issue.Status = _newStatus;
        issue.LastModifiedDate = DateTime.Now;
        _repository.Update(issue);
    }

    public void Undo()
    {
        var issue = _repository.GetById(_issueId);
        issue.Status = _oldStatus;
        _repository.Update(issue);
    }

    public string Description => $"Changed issue #{_issueId} status to {_newStatus}";
    public DateTime Timestamp { get; }
    public CommandType Type => CommandType.Update;
}