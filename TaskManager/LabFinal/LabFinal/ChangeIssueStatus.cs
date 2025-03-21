namespace LabFinal;

    public class ChangeIssueStatusCommand : ICommand
    {
        private readonly IssueRepository _repository;
        private readonly int _issueId;
        private readonly Status _newStatus;
        private Status _oldStatus;
        private CommandLog _log;

        public ChangeIssueStatusCommand(IssueRepository repository, int issueId, Status newStatus)
        {
            _repository = repository;
            _issueId = issueId;
            _newStatus = newStatus;
        }

        public void Execute()
        {
            var issue = _repository.GetIssue(_issueId);
            _oldStatus = issue.Status;
            issue.Status = _newStatus;
            issue.LastModifiedDate = DateTime.Now;
            _log = new CommandLog(CommandType.Update, $"Changed status of issue {_issueId} to {_newStatus}");
        }

        public void Undo()
        {
            var issue = _repository.GetIssue(_issueId);
            issue.Status = _oldStatus;
            issue.LastModifiedDate = DateTime.Now;
        }

        public CommandLog GetLog() => _log;
    }
