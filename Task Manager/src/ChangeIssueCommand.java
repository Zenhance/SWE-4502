public class ChangeIssueCommand implements Command{
    public Issue issue;
    public IssueRepository issueRepository;
    private String previousStatus;
    private String newStatus;

    public ChangeIssueCommand(Issue issue, IssueRepository issueRepository, String previousStatus, String newStatus) {
        this.issue = issue;
        this.issueRepository = issueRepository;
        this.previousStatus = issue.getStatus();
        this.newStatus = newStatus;
    }

    @Override
    public void execute(){
        issue.setStatus(newStatus);
        issueRepository.updateIssue(issue);

    }

    @Override
    public void undo(){
        issue.setStatus(previousStatus);
        issueRepository.updateIssue(issue);
    }
}
