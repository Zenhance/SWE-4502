import java.util.Stack;

class ChangeStatusCommand implements Command {
    private Issue issue;
    private Status newStatus;
    private Status previousStatus;

    public ChangeStatusCommand(Issue issue, Status newStatus) {
        this.issue = issue;
        this.newStatus = newStatus;
    }

    @Override
    public void execute() {
        previousStatus = issue.getStatus(); // Save previous state for undo
        issue.changeStatus(newStatus);
    }

    @Override
    public void undo() {
        issue.changeStatus(previousStatus);
    }
}

