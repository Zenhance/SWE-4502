using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace TaskManager
{
    public class UpdateIssueCommand : ICommand
    {
        private IssueRepository repository;
        private Issue newIssue, oldIssue;

        public UpdateIssueCommand(IssueRepository repo, Issue issue)
        {
            repository = repo;
            oldIssue = (Issue)repo.GetIssue(issue.Id)?.Clone();
            newIssue = issue;
        }



        public void Execute()
        {
            repository.UpdateIssue(newIssue);
        }

        public void Undo()
        {
            repository.UpdateIssue(oldIssue);
        }

        public string Description => $"Update Issue {newIssue.Id}";
    
    }
}
