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
        public class CreateIssueCommand : ICommand
        {
            private readonly IssueRepository _repository;
            private readonly Issue _issue;

            public CreateIssueCommand(IssueRepository repository, Issue issue)
            {
                _repository = repository;
                _issue = issue;
                Timestamp = DateTime.UtcNow;
            }

            public string Description => $"Created issue: {_issue.Title}";
            public DateTime Timestamp { get; }
            public CommandType Type => CommandType.Create;

            public void Execute()
            {
                _repository.Add(_issue);
            }

            public void Undo()
            {
                _repository.Remove(_issue.Id);
            }
        }
    }
}
