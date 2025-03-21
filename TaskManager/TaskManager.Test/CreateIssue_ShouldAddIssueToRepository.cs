using System.Windows.Input;
using TaskManager.ENUM;
using TaskManagerOriginal;
using TaskManagerOriginal.Command;
using TaskManagerOriginal.ENUM;
using TaskManagerOriginal.Model;

namespace TaskManager.Test;


public class CreateIssue_ShouldAddIssueToRepository
{
    [Fact]
    public void CreateIssueTest()
    {
        User shuvro = new User("rakin");
        Mediate userMediator = new Mediate();

        IssueMan issueManager = new IssueMan();

        
        
        
    }
}