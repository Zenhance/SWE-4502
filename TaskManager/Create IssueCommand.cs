using System;

public class CreateIssueCommand : ICommand
{
   
        private IssueRepository _repository;
        private Issue _issue;

        public CreateIssueCommand(IssueRepository repository, Issue issue)
        {
            _repository = repository;
            _issue = issue;
        }

        public void Execute() => _repository.AddIssue(_issue);
        public void Undo() => _repository.GetIssue(_issue.Id)?.Comments.Clear();
    
}
