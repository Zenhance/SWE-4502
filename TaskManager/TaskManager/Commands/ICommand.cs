using TaskManager.Domain;
using TaskManager.Repositories;

namespace TaskManager.Commands;

public interface ICommand<T> where T: Entity
{
    T Execute(IRepository<T> repo);
    void Undo(IRepository<T> repo);
}
