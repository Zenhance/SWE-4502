using TaskManagerOriginal.Model;

namespace TaskManagerOriginal;

public class IssueMan
{
    public List <Issue> issues;
    public Mediate mediator;
    
    public IssueMan()
    {
        issues = new List<Issue>();
        mediator = new Mediate();
    }
    
    
}