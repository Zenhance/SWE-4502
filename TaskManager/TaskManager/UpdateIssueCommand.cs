using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace TaskManager
{
    class UpdateIssueCommand :ICommand
    {
        public IssueRepository repository;
        Issue newIssue, oldIssue;

        public UpdateIssueCommand(IssueRepository repository, Issue newIssue, Issue oldIssue)
        {
            this.repository = repository;
            this.newIssue = newIssue;
            this.oldIssue = oldIssue;
        }

        public void Execute()
        {

        }
    }
}
