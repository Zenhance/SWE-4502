public class ChangeStatusCommand implements ICommand

{
    private final Issue issue;
    private final String oldStatus;
    private final String newStatus;

    public ChangeStatusCommand(Issue issue, String newStatus) {
        this.issue = issue;
        this.oldStatus = issue.getStatus();
        this.newStatus = newStatus;
    }

    @Override
    public void execute() {
        issue.changeStatus(newStatus);
        System.out.println("Status changed to " + newStatus + " for issue " + issue.getId());
    }

    @Override
    public void undo() {
        issue.changeStatus(oldStatus);
        System.out.println("Undo: Reverted status to " + oldStatus);
    }

    @Override
    public String getDescription() {
        return "Change Status to " + newStatus;
    }
}
