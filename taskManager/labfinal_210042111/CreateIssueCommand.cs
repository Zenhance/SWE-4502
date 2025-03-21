using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace labfinal_210042111
{
    public class CreateIssueCommand : ICommand
    {
        private IssueRepository repository;
        private Issue issue;

        public CreateIssueCommand(IssueRepository repository, Issue issue)
        {
            this.repository = repository;
            this.issue = issue;
        }

        public void Execute()
        {
            repository.addIssue(issue);
        }
        public string undo()
        {
            repository.removeIssue(issue.GetId());
            return "success";
        }

    }
}