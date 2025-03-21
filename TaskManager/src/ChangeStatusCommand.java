public class ChangeStatusCommand implements Command {
    private IssueRepository repository;
    private Issue issue;
    private Status newStatus;
    private Status oldStatus;
    public ChangeStatusCommand(IssueRepository repository, Issue issue, Status newStatus) {
        this.repository = repository;
        this.issue = issue;
        this.newStatus = newStatus;
    }
    @Override
    public void execute() {
        oldStatus = issue.getStatus();
        issue.changeStatus(newStatus);
    }
    @Override
    public void undo() {
        issue.changeStatus(oldStatus);
    }
}