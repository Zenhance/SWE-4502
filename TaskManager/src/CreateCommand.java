public class CreateCommand implements Command{

    IssueRepository issueRepository;
    Issue issue;
    public CreateCommand(IssueRepository issueRepository,Issue issue){
        this.issueRepository = issueRepository;
        this.issue = issue;
    }
    @Override
    public void execute() {
        issueRepository.createIssue();
    }
}
