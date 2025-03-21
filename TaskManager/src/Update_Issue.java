public class Update_Issue implements Command {
    private IssueRepository repository;
    private String issueId;
    private Issue oldIssue;
    private Issue newIssue;

    public Update_Issue(IssueRepository repository, String issueId, Issue newIssue) {
        this.repository = repository;
        this.issueId = issueId;
        this.newIssue = newIssue;
        this.oldIssue = repository.getIssue(issueId);
    }

    @Override
    public void execute() {
        repository.updateIssue(issueId, newIssue);
    }

    @Override
    public void undo() {
        repository.updateIssue(issueId, oldIssue);
    }
}
