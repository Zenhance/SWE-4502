public class UpdateIssueCommand implements Command{
    public Issue issue;
    public IssueRepository issueRepository;
    private Issue previousState;

    public UpdateIssueCommand(Issue issue, IssueRepository issueRepository, Issue previousState) {
        this.issue = issue;
        this.issueRepository = issueRepository;
        this.previousState = previousState;
    }

    @Override
    public void execute(){
        previousState = new Issue(issue);
        issueRepository.updateIssue(issue);
    }

    @Override
    public void undo(){
        issueRepository.updateIssue(previousState);
    }
}
