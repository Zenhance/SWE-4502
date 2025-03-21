namespace LabFinal;
    public class AddCommentCommand : ICommand
    {
        private readonly IssueRepository _repository;
        private readonly int _issueId;
        private readonly Comment _comment;
        private CommandLog _log;

        public AddCommentCommand(IssueRepository repository, int issueId, Comment comment)
        {
            _repository = repository;
            _issueId = issueId;
            _comment = comment;
        }

        public void Execute()
        {
            var issue = _repository.GetIssue(_issueId);
            issue.Comments.Add(_comment);
            _log = new CommandLog(CommandType.Update, $"Added comment to issue {_issueId}");
        }

        public void Undo()
        {
            var issue = _repository.GetIssue(_issueId);
            issue.Comments.Remove(_comment);
        }

        public CommandLog GetLog() => _log;
    }
