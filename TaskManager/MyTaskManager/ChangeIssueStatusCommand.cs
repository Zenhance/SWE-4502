using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace MyTaskManager
{
    public class ChangeIssueStatusCommand : Command
    {
        public IssueRepository repository;
        public int issueId;
        public Status newStatus;
        public Status oldStatus;

        public ChangeIssueStatusCommand(IssueRepository repository, int issueId, Status newStatus)
        {
            this.repository = repository;
            this.issueId = issueId;
            this.newStatus = newStatus;
            this.Type = CommandType.Update;
            this.Description = $"Changed issue id{issueId} status to {newStatus}";
        }

        public override void Execute()
        {
            Issue issue = repository.GetIssue(issueId);
            if (issue != null)
            {
                oldStatus = issue.Status;
                issue.Status = newStatus;
                issue.LastModifiedDate = DateTime.Now;
                repository.UpdateIssue(issue);
            }
        }

        public override void Undo()
        {
            Issue issue = repository.GetIssue(issueId);
            if (issue != null)
            {
                issue.Status = oldStatus;
                issue.LastModifiedDate = DateTime.Now;
                repository.UpdateIssue(issue);
            }
        }
    }
}
