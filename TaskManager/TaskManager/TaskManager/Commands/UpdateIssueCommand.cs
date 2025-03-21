using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using TaskManager.Models;
using TaskManager.Repository;
using System.Threading.Tasks;

namespace TaskManager.Commands
{
    namespace TaskManager.Commands
    {
        public class UpdateIssueCommand : ICommand
        {
            private readonly IssueRepository _repository;
            private readonly Issue _newIssue;
            private readonly Issue _oldIssue;

            public UpdateIssueCommand(IssueRepository repository, Issue newIssue)
            {
                _repository = repository;
                _newIssue = newIssue;
                _oldIssue = repository.GetById(newIssue.Id);
                Timestamp = DateTime.UtcNow;
            }

            public string Description => $"Updated issue: {_newIssue.Title}";
            public DateTime Timestamp { get; }
            public CommandType Type => CommandType.Update;

            public void Execute()
            {
                _repository.Update(_newIssue);
            }

            public void Undo()
            {
                _repository.Update(_oldIssue);
            }
        }
    }
}
