public class ChangeStatusCommand implements ChangeStatusCommand{
    private Issue issue;
    public ChangeStatusCommand(Issue issue){
        this.issue=issue;
    }
    public void execute(){
        issue.changeStatus();
    }
}