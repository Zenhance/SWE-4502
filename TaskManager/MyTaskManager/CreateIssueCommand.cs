using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace MyTaskManager
{
    public class CreateIssueCommand : Command
    {
        public IssueRepository repository;
        public Issue issue;

        public CreateIssueCommand(IssueRepository repository, string title, string description, Priority priority)
        {
            this.repository = repository;
            int issueId = repository.GetNextIssueId();
            this.issue = new Issue(issueId, title, description, priority);
            this.Type = CommandType.Create;
            this.Description = $"Created JIssueID: {issueId}, Title: {title}";
        }

        public override void Execute()
        {
            repository.AddIssue(issue);
        }

        public override void Undo()
        {
            var repositoryIssues = repository.GetAllIssues();
            repositoryIssues.Remove(issue.Id);
        }
    }
}
