public class ChangeCommand implements Command{
    Issue issue;
    Enum<STATUS> status;

    public ChangeCommand(Issue issue, Enum<STATUS> status) {
        this.issue = issue;
        this.status = status;
    }

    @Override
    public Issue execute() {
        return issue.changeStatus(status);
    }
}
