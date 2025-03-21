using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace TaskManager
{
    public class UpdateIssueCommand : ICommand
    {
        private IssueRepository _repo;
        private Issue _oldIssue;
        private Issue _newIssue;

        public UpdateIssueCommand(IssueRepository repo, Issue oldIssue, Issue newIssue)
        {
            _repo = repo;
            _oldIssue = oldIssue;
            _newIssue = newIssue;
        }

        public void Execute()
        {
            _repo.UpdateIssue(_newIssue);
        }

        public void Undo()
        {
            _repo.UpdateIssue(_oldIssue);
        }
    }
}
