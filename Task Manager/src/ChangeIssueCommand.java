public class ChangeIssueCommand implements Command{
    public Issue issue;
    public IssueRepository issueRepository;
    private String previousStatus;
    private String newStatus;

    public ChangeIssueCommand(Issue issue, IssueRepository issueRepository, String previousStatus, String newStatus) {
        this.issue = issue;
        this.issueRepository = issueRepository;
        this.previousStatus = previousStatus;
        this.newStatus = newStatus;
    }

    @Override
    public void execute(){
        previousStatus = issue.getStatus();
        issue.setStatus(newStatus);
        issueRepository.updateIssue(issue);

    }

    @Override
    public void undo(){
        issue.setStatus(previousStatus);
        issueRepository.updateIssue(issue);
    }
}
