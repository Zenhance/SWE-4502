public class CreateIssueCommand implements Command{
    public Issue issue;
    public IssueRepository issueRepository;

    public CreateIssueCommand(Issue issue, IssueRepository issueRepository) {
        this.issue = issue;
        this.issueRepository = issueRepository;
    }

    @Override
    public void execute(){
        issueRepository.addIssue(issue);
    }

    @Override
    public void undo(){
        issueRepository.removeIssue(issue);
    }



}
