using TaskManager.Models;
using TaskManager.Repositories;
namespace TaskManager.Commands;

public class ChangeStatusCommand:Command
{
    private readonly IssueRepository _repository;
    private readonly int _issueId;
    private readonly Status _newStatus;
    private Status _previousStatus;

    public ChangeStatusCommand(IssueRepository repository, int issueId, Status newStatus)
    {
        _repository = repository;
        _issueId = issueId;
        _newStatus = newStatus;
        Description=$"Changed status of issue with ID: {issueId} to {newStatus}";
        Timestamp=DateTime.Now;
        Type=CommandType.Update;
    }

    public override void Undo()
    {
       var issue = _repository.GetIssue(_issueId);
       if (issue != null)
       {
           issue.Status = _previousStatus;
           _repository.UpdateIssue(issue);
       }
        
    }

    public override void Execute()
    {
       var issue = _repository.GetIssue(_issueId);
       if (issue != null)
       {    
           _previousStatus = issue.Status;
           issue.Status = _newStatus;
           _repository.UpdateIssue(issue);
       }
    }
    
    
}