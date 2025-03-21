public class CreateCommand implements Command{
    private Issue issue;

    public CreateCommand(IssueRepository issueRepository){
        this.issue=issue;
    }

    public void execute(){
        issueRepository.create();
    }
}