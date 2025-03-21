using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using TaskManager;

namespace TaskManager
{
    public class CreateIssueCommand : ICommand
    {
        private IssueRepository _repo;
        private Issue _Issue;

        public CreateIssueCommand(IssueRepository repo, Issue issue)
        {
            _repo = repo;
            _Issue = issue;
        }

        public void Execute()
        {
            _repo.AddIssue(_Issue);
        }

        public void Undo()
        {
            _repo.DeleteIssue(_Issue.Id);
        }
    }
}



