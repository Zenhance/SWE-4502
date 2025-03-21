using TaskManager.Commands;
using TaskManager.Models;
using TaskManager.Repositories;

namespace TaskManager.Commands;

public class UpdateIssueCommand :Command
{
    private readonly IssueRepository _repository;
    private readonly Issue _updatedIssue;
    private Issue _originalIssue;
    
    public UpdateIssueCommand(IssueRepository repository, Issue updatedIssue){
        _repository = repository;
        _updatedIssue = updatedIssue;    
        Description=$"Updated issue with ID: {updatedIssue.Id}";
        Timestamp=DateTime.Now;
        Type=CommandType.Update;
    }

    public override void Execute()
    {
        _originalIssue=_repository.GetIssue(_updatedIssue.Id);
        _repository.UpdateIssue(_updatedIssue); 
    }

    public override void Undo()
    {
        if (_originalIssue != null)
        {
            _repository.UpdateIssue(_originalIssue);
        }
    }
}