using TaskManager.Domain;

namespace TaskManager.Repositories;

public interface IRepository<T> where T: Entity
{
    T Create(T enitity);
    T FindById(int id);
    void UndoCreate();
}
