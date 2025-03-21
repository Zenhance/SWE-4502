public class CreateCommand implements Command{
    private IssueRepository issueRepository;
    private Issue issue;
    public int id;

    public CreateCommand(IssueRepository issueRepository,Issue issue){
        this.issueRepository=issueRepository;
    }

    public void execute(){
        issueRepository.create(id,issue);
    }
}