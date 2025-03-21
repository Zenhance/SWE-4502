public class UpdateCommand implements Command{
    private Issue issue;
    private String property;
    public UpdateCommand(Issue issue){
        this.issue=issue;
        this.property=property;
    }
    public void execute(){
        issue.update(property);
    }
}