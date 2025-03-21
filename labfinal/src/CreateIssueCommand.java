public class CreateIssueCommand extends Command {
    private Issue issue;
    private IssueRepository issueRepository;
    public CreateIssueCommand(Issue _issue,IssueRepository _issueRep){
        super(_issue.getTitle(),OperationType.CREATE);
        this.issue = _issue;
        this.issueRepository = _issueRep;
    }

    public void execute(){
       issueRepository.registerIssue(issue);
    }

    public void undo(){
      issueRepository.removeIssue(issue.getId());
    }

    public Issue getIssue(){
        return issue;
    }

    public IssueRepository getIssueRepository(){
        return issueRepository;
    }
}
