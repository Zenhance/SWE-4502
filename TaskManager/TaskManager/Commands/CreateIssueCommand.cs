using TaskManager.Models;
using TaskManager.Repositories;

namespace TaskManager.Commands;

public class CreateIssueCommand : Command 
{
    private readonly IssueRepository _repository;
    private readonly Issue _issue;

    public CreateIssueCommand(IssueRepository repository, Issue issue)
    {
        _repository = repository;
        _issue = issue;
        Description=$"Created issue with title: {issue.Title}";
        Timestamp=DateTime.Now;
        Type=CommandType.Create;
    }

    public override void Execute()
    {
        _repository.AddIssue(_issue);
    }

    public override void Undo()
    {
        
    }
}
