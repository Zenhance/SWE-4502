namespace LabFinal
{
    public class CreateIssueCommand : ICommand
    {
        private readonly IssueRepository _repository;
        private readonly Issue _issue;
        private CommandLog _log;

        public CreateIssueCommand(IssueRepository repository, Issue issue)
        {
            _repository = repository;
            _issue = issue;
            _log = new CommandLog(CommandType.Create, $"Created Issue with ID {_issue.Id}");
        }

        public void Execute()
        {
            _repository.AddIssue(_issue);
        }

        public void Undo()
        {
            _repository.RemoveIssue(_issue.Id);
        }

        public CommandLog GetLog() => _log;
    }
}