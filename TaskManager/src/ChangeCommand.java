public class ChangeCommand implements Command{
    Issue issue;
    Enum<STATUS> status;
    Enum<STATUS> prev_status;

    public ChangeCommand(Issue issue, Enum<STATUS> status) {
        this.issue = issue;
        this.status = status;
    }

    @Override
    public Issue execute() {
        prev_status = issue.getStatus();
        return issue.changeStatus(status);
    }

    @Override
    public Issue undo() {
        prev_status = issue.getStatus();
        return issue.changeStatus(prev_status);
    }
}
