public class UpdateIssueCommand extends Command{
    private final IssueRepository repository;
    private final String issueId;
    private final Issue newIssue;
    private Issue oldIssue;

    public UpdateIssueCommand(IssueRepository repository, String issueId, Issue newIssue) {
        super("Updated issue: " + newIssue.getTitle(), CommandType.UPDATE);
        this.repository = repository;
        this.issueId = issueId;
        this.newIssue = newIssue;
    }

    @Override
    public void execute() {
        oldIssue = repository.getIssue(issueId).clone();
        repository.updateIssue(newIssue);
    }

    @Override
    public void undo() {
        if (oldIssue != null) {
            repository.updateIssue(oldIssue);
        }
    }
}
