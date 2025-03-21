using TaskManager.Domain;

namespace TaskManager.Repositories;

public class IssueRepository
{
    private int _id = 0;
    private HashSet<Issue> _issues = new HashSet<Issue>();

    public Issue Create(Issue issue)
    {
        _id++;
        issue.Id = _id;
        _issues.Add(issue);
        return issue;
    }

    public Issue? FindById(int id)
    {
        return _issues.Where(i => i.Id == id).First();
    }
}
