public class ChangeStatusCommand implements Command{
    private Issue issue;
    public Status status;
    public ChangeStatusCommand(Issue issue){
        this.issue=issue;
    }
    public void execute(){
        issue.changeStatus(status);
    }
}