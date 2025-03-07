using BankApp.Queries;
namespace BankApp.Executor;

public class QueryExecutor
{
    public void ExecuteQuery(IQuery query)
    {
        query.Query();
    }
}