
public class Change_Issue_Status implements Command {
    private IssueRepository repository;
    private String issueId;
    private Status OldStatus;
    private Status newStatus;

    public Change_Issue_Status(IssueRepository repository, String issueId, Status newStatus) {
        this.repository = repository;
        this.issueId = issueId;
        this.newStatus = newStatus;
        this.OldStatus = repository.getIssue(issueId).getStatus();
    }

    @Override
    public void undo() {
        Issue issue = repository.getIssue(issueId);
        issue.setStatus(OldStatus);
    }




    @Override
    public void execute() {
        Issue issue = repository.getIssue(issueId);
        issue.setStatus(newStatus);
    }
}