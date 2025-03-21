namespace LabFinal;

    public class UpdateIssueCommands : ICommand
    {
        private readonly IssueRepository _repository;
        private readonly Issue _updatedIssue;
        private Issue _originalIssue;
        private readonly CommandLog _log;

        public UpdateIssueCommands(IssueRepository repository, Issue updatedIssue)
        {
            if (repository == null)
                throw new ArgumentNullException(nameof(repository));
            if (updatedIssue == null)
                throw new ArgumentNullException(nameof(updatedIssue));
            
            _repository = repository;
            _updatedIssue = updatedIssue;
            _log = new CommandLog(CommandType.Update, $"Updated Issue with ID {_updatedIssue.Id}");
        }

        public void Execute()
        {
            var originalIssue = _repository.GetIssue(_updatedIssue.Id);
            if (originalIssue == null)
            {
                throw new InvalidOperationException($"Issue with ID {_updatedIssue.Id} not found.");
            }
            
            _originalIssue = (Issue)originalIssue.Clone();
            
            _repository.UpdateIssue(_updatedIssue); 
        }

        public void Undo()
        {
            if (_originalIssue == null)
            {
                throw new InvalidOperationException("Cannot undo because Execute was not called.");
            }
            
            _repository.UpdateIssue(_originalIssue); 
        }

        public CommandLog GetLog() => _log;
    }
