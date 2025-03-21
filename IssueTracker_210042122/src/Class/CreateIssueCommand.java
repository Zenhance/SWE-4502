package Class;

public class CreateIssueCommand implements Command {
    private IssueRepository issueRepository;
    private Issue issue;


    public CreateIssueCommand(IssueRepository issueRepository, Issue issue) {
        this.issueRepository=issueRepository;
        this.issue = issue;
    }

    @Override
    public void Execute() {
        issueRepository.CreateIssue( issue);

    }



    @Override
    public void Undo() {
        // i will do that later on
    }
}
