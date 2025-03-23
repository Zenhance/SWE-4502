using TaskManager.Domain;
using TaskManager.Repository;

namespace TaskManager.Commands;

public class UpdateIssueCommand : ICommand
{
    private readonly IssueRepository _repository;
    private readonly Issue _newIssue;
    private Issue _oldIssue;

    public UpdateIssueCommand(IssueRepository repository, Issue issue)
    {
        _repository = repository;
        _newIssue = issue;
        Timestamp = DateTime.Now;
    }

    public void Execute()
    {
        _oldIssue = _repository.GetById(_newIssue.Id).Clone();
        _repository.Update(_newIssue);
    }

    public void Undo()
    {
        _repository.Update(_oldIssue);
    }

    public string Description => $"Updated issue: {_newIssue.Title}";
    public DateTime Timestamp { get; }
    public CommandType Type => CommandType.Update;
}