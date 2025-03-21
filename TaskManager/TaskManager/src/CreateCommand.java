public class CreateCommand implements Command{
    private Issue issue;

    public CreateCommand(Issue issue){
        this.issue=issue;
    }

    public void execute(){
        issue.create();
    }
}