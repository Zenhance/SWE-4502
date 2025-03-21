using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace TaskManager_112
{
    public class CreateIssueCommand : ICommand
    {
        private IssueRepository repository;
        private Issue issue;
        public CreateIssueCommand(IssueRepository repo, Issue issue)
        {
            repository = repo;
            this.issue = issue;
        }
        public void Execute()
        {
            repository.CreateIssue(issue);
        }
        public void Undo()
        {
            Console.WriteLine($"Undid the last created issue: {issue.ID}");
        }
    }
}
