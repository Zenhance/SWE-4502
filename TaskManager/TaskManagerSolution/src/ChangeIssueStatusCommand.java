public class ChangeIssueStatusCommand extends Command{
    private final IssueRepository repository;
    private final String issueId;
    private final Status newStatus;
    private Status oldStatus;

    public ChangeIssueStatusCommand(IssueRepository repository, String issueId, Status newStatus) {
        super("Changed issue status to: " + newStatus, CommandType.UPDATE);
        this.repository = repository;
        this.issueId = issueId;
        this.newStatus = newStatus;
    }

    @Override
    public void execute() {
        Issue issue = repository.getIssue(issueId);
        oldStatus = issue.getStatus();
        issue.setStatus(newStatus);
    }

    @Override
    public void undo() {
        if (oldStatus != null) {
            Issue issue = repository.getIssue(issueId);
            issue.setStatus(oldStatus);
        }
    }

}
