using TaskManager.Domain;
using TaskManager.Repositories;

namespace TaskManager.Commands;

public class CreateIssueCommand : ICommand<Issue>
{

    public Issue Execute(IRepository<Issue> repo)
    {
        
    }

    public void Undo(IRepository<Issue> repo)
    {
        throw new NotImplementedException();
    }
}
