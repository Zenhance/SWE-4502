public class Create_Issue implements Command {
    private IssueRepository repository;
    private Issue isssue;

    public Create_Issue(IssueRepository repository, Issue issue) {
        this.repository = repository;
        this.isssue = issue;
    }

    @Override
    public void execute() {
        repository.addIssue(isssue);
    }

    @Override
    public void undo() {
        repository.deleteIssue(isssue.getId());
    }
}