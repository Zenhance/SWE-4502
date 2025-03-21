using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace TaskManager
{
    public class CreateIssueCommand : ICommand
    {
        private IssueRepository repository;
        private Issue issue;
        private IObserver observer;

        public CreateIssueCommand(IssueRepository repo, Issue issue, IObserver obs)
        {
            this.repository = repo;
            this.issue = issue;
            this.observer = obs;
        }

        public void Execute()
        {
            repository.AddIssue(issue);
            observer.Notify($"Issue {issue.Id} created: {issue.Title}");
        }

        public void Undo()
        {
            repository.UpdateIssue(null);
            observer.Notify($"Issue {issue.Id} creation undone.");
        }

        public string Description => $"Create Issue {issue.Id}";
    }
}
