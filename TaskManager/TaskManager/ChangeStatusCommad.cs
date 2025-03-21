using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace TaskManager
{
    class ChangeStatusCommand : ICommand
    {
        private IssueRepository repository;
        private int issueId;
        private Status oldStatus, newStatus;
        private IObserver observer;
        private Issue issue;



        public ChangeStatusCommand(IssueRepository repo, int issueId, Status newStatus, IObserver obs)
        {
            repository = repo;
            this.issueId = issueId;
            this.newStatus = newStatus;
            this.observer = obs;
        }



        public void Execute()
        {
            var issue = repository.GetIssue(issueId);
            if (issue != null)
            {
                oldStatus = issue.Status;
                issue.Status = newStatus;
                observer.Notify($"Issue {issueId} status changed to {newStatus}");
            }
        }

        public void Undo()
        {
            var issue = repository.GetIssue(issueId);
            if (issue != null)
            {
                issue.Status = oldStatus;
                observer.Notify($"Undo: Issue {issueId} reverted to {oldStatus}");
            }
        }

        public string Description => $"Change Status ";
    }
}
