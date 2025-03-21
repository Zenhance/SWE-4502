using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace labfinal_210042111
{
    public class ChangeIssueStatusCommand : ICommand
    {
        private IssueRepository repository;
        private Issue issue;
        private Status newStatus;
        private Status oldStatus;
        public ChangeIssueStatusCommand(IssueRepository repository, Issue issue, Status newStatus)
        {
            this.repository = repository;
            this.issue = issue;
            this.newStatus = newStatus;

        }
        public void Execute()
        {
            oldStatus = issue.getStatus();
            issue.changeStatus(newStatus);
        }

        public void undo()
        {
            issue.changeStatus(oldStatus);
        }
    }
}
