public class ChangeStatus implements Command{

    IssueRepository repository;

    Issue issue;

    Status status;

    Status oldStatus;

    public ChangeStatus(IssueRepository repository, Issue issue, Status status){
        this.repository=repository;
        this.issue=issue;
        this.status=status;
    }

    @Override
    public void execute() {
        oldStatus=issue.getStatus();
        issue.setStatus(status);
    }

    @Override
    public void undo() {
        issue.setStatus(oldStatus);
    }
}
