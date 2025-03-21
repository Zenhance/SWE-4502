
class UpdateCommand implements ICommand {
    private final Issue issue;
    private final Status newStatus;
    private Status previousStatus;

    public UpdateCommand(Issue issue, Status newStatus) {
        this.issue = issue;
        this.newStatus = newStatus;
    }

    public void execute() {
        previousStatus = issue.getStatus();
        issue.changeStatus(newStatus);
        System.out.println("Changed status: " + issue);
    }

    public void undo() {
        issue.changeStatus(previousStatus);
        System.out.println("Undo: Reverted status to " + previousStatus);
    }
}