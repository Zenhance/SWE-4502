public class IssueCommand extends Command{
    private  IssueRepository repository;

    private  Issue issue;

    private boolean isExecuted= false;

    public IssueCommand(IssueRepository repository, Issue issue) {
        super("Created issue: " + issue.getTitle(), CommandType.Create);
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