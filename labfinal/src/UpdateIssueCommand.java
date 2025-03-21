public class UpdateIssueCommand extends Command{
    private Issue issue;
    private IssueRepository issueRepository;
    private Issue updatedIssue;
    public UpdateIssueCommand(Issue _issue,IssueRepository _issueRep,Issue _updatedIssue){
        super(_updatedIssue.getTitle(),OperationType.UPDATE);
        this.issue = _issue;
        this.issueRepository = _issueRep;
        this.updatedIssue = _updatedIssue;
    }

    public void execute(){
        issueRepository.updateIssue(issue,updatedIssue);

    }

    public void undo(){
        issueRepository.updateIssue(updatedIssue,issue);
    }

    public Issue getIssue(){
        return issue;
    }

    public Issue getUpdatedIssue(){
        return updatedIssue;
    }

    public IssueRepository getIssueRepository(){
        return issueRepository;
    }
}
