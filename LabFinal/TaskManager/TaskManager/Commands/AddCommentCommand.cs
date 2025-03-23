using TaskManager.Domain;
using TaskManager.Repository;

namespace TaskManager.Commands;

public class AddCommentCommand : ICommand
{
    private readonly IssueRepository _repository;
    private readonly int _issueId;
    private readonly Comment _comment;
    private int _addedCommentId;

    public AddCommentCommand(IssueRepository repository, int issueId, Comment comment)
    {
        _repository = repository;
        _issueId = issueId;
        _comment = comment;
        Timestamp = DateTime.Now;
    }

    public void Execute()
    {
        _addedCommentId = _repository.AddComment(_issueId, _comment);
    }

    public void Undo()
    {
        _repository.RemoveComment(_issueId, _addedCommentId);
    }

    public string Description => $"Added comment to issue #{_issueId}";
    public DateTime Timestamp { get; }
    public CommandType Type => CommandType.Update;
}