public class Create_Issue implements Command {
    private IssueRepository repository;
    private Issue issue;

    public Create_Issue(IssueRepository repository, Issue issue) {
        this.repository = repository;
        this.issue = issue;
    }

    @Override
    public void execute() {
        repository.addIssue(issue);
    }

    @Override
    public void undo() {
        repository.deleteIssue(issue.getId());
    }
}