class ChangeStatus implements Command {
    public Issue issue;
    public Status oldStatus;
    public Status newStatus;

    public ChangeStatus(Issue issue, Status newStatus) {
        this.issue = issue;
        this.oldStatus = issue.getStatus();
        this.newStatus = newStatus;
    }

    @Override
    public void execute() {
        issue.changeStatus(newStatus);
        System.out.println("Status changed to " + newStatus + " for issue " + issue.getId());
    }


    public void undo() {
        issue.changeStatus(oldStatus);
        System.out.println("Undo: Reverted status to " + oldStatus);
    }


    public String getDescription() {
        return "Change Status to " + newStatus;
    }
}