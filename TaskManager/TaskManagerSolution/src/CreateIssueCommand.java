public class CreateIssueCommand extends Command{
    private final IssueRepository repository;

    private final Issue issue;

    private boolean isExecuted= false;

    public CreateIssueCommand(IssueRepository repository, Issue issue) {
        super("Created issue: " + issue.getTitle(), CommandType.CREATE);
        this.repository = repository;
        this.issue = issue;
    }

    @Override
    public void execute() {
        repository.addIssue(issue);
        isExecuted = true;
    }

    @Override
    public void undo() {
        if (isExecuted) {
            repository.removeIssue(issue.getId());
            isExecuted = false;
        }
    }

    public Issue getIssue() {
        return issue;
    }
}
