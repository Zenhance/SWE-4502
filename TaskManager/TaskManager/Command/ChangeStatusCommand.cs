using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace TaskManager.Command
{
    public class ChangeStatusCommand : ICommand
    {
        private IssueRepository repo;
        private Issue issue;
        private Status oldStatus;
        private Status newStatus;

        public ChangeStatusCommand(IssueRepository repo, Issue issue, Status newStatus)
        {
            this.repo = repo;
            this.issue = issue;
            this.oldStatus = issue.status;
            this.newStatus = newStatus;
        }

        public void Execute()
        {
            issue.status = newStatus;
            repo.UpdateIssue(issue);
        }

        public void Undo()
        {
            issue.status = oldStatus;
            repo.UpdateIssue(issue);
        }
    }
}
