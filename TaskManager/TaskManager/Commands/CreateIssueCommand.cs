using TaskManager.Domain;
using TaskManager.Repository;

namespace TaskManager.Commands;

public class CreateIssueCommand : ICommand
{
    private readonly IssueRepository _repository;
    private readonly Issue _issue;
    private int _createdIssueId;

    public CreateIssueCommand(IssueRepository repository, Issue issue)
    {
        _repository = repository;
        _issue = issue;
        Timestamp = DateTime.Now;
    }

    public void Execute()
    {
        _createdIssueId = _repository.Add(_issue);
    }

    public void Undo()
    {
        _repository.Remove(_createdIssueId);
    }

    public string Description => $"Created issue: {_issue.Title}";
    public DateTime Timestamp { get; }
    public CommandType Type => CommandType.Create;
}