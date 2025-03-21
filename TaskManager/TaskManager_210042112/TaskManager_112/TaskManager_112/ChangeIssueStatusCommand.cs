using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace TaskManager_112
{
    public class ChangeIssueStatusCommand : ICommand
    {
        private Issue issue;
        private Status previousStatus;
        private Status newStatus;
        public ChangeIssueStatusCommand(Issue issue, Status newStatus)
        {
            this.issue = issue;
            this.previousStatus = issue.Status;
            this.newStatus = newStatus;
        }
        public void Execute()
        {
            issue.ChangeStatus(newStatus);
        }
        public void Undo()
        {
            issue.ChangeStatus(previousStatus);
        }
    }
}
