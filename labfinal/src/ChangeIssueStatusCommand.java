public class ChangeIssueStatusCommand extends Command{
    private String issueId;
    private IssueRepository issueRepository;
    private StatusType status;
    private StatusType newStatus;
    public ChangeIssueStatusCommand(String _issueId,IssueRepository _issueRep,StatusType _status){
        super("Status changed",OperationType.CHANGE);
        this.issueId = _issueId;
        this.issueRepository = _issueRep;
        this.newStatus= _status;
    }

    public void execute(){
        Issue issue = issueRepository.getIssue(issueId);
        status = issue.getStatus();
        issue.setStatus(newStatus);
    }

    public void undo(){
        if (status != null) {
            Issue issue = issueRepository.getIssue(issueId);
            issue.setStatus(status);
        }
    }

    public IssueRepository getIssueRepository(){
        return issueRepository;
    }
}
