using TaskManager.Commands;
using TaskManager.Domain;
using TaskManager.Repository;
using TaskManager.Subjects;

namespace TaskManager.Service;

public class IssueService
{
    private readonly IssueRepository _repository;
    private readonly CommandManager _commandManager;

    public IssueService(IssueRepository repository, CommandManager commandManager)
    {
        _repository = repository;
        _commandManager = commandManager;
    }

    public int CreateIssue(string title, string description, IssuePriority priority, string assignedTo = null)
    {
        var issue = new Issue
        {
            Title = title,
            Description = description,
            Priority = priority,
            AssignedTo = assignedTo
        };

        var command = new CreateIssueCommand(_repository, issue);
        _commandManager.ExecuteCommand(command);
        return issue.Id;
    }

    public void UpdateIssue(Issue issue)
    {
        var command = new UpdateIssueCommand(_repository, issue);
        _commandManager.ExecuteCommand(command);
    }

    public void AddComment(int issueId, string content, string author)
    {
        var comment = new Comment
        {
            Content = content,
            Author = author
        };
        var command = new AddCommentCommand(_repository, issueId, comment);
        _commandManager.ExecuteCommand(command);
    }

    public void ChangeStatus(int issueId, IssueStatus status)
    {
        var command = new ChangeIssueStatusCommand(_repository, issueId, status);
        _commandManager.ExecuteCommand(command);
    }

    public Issue GetIssue(int id)
    {
        return _repository.GetById(id);
    }

    public IEnumerable<Issue> GetAllIssues()
    {
        return _repository.GetAll();
    }

    public void UndoLastCommand()
    {
        _commandManager.Undo();
    }

    public void RedoCommand()
    {
        _commandManager.Redo();
    }

    public IEnumerable<ICommand> GetCommandHistory()
    {
        return _commandManager.GetCommandHistory();
    }
}