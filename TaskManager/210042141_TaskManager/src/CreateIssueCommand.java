public class CreateIssueCommand implements Command{
    private IssueRepository repository;
    private Issue issue;

    public CreateIssueCommand(IssueRepository repository, Issue issue){
        this.repository = repository;
        this.issue = issue;
    }

    @Override
    public void execute(){
        repository.addIssue(issue);
    }

    @Override
    public void undo(){
        repository.removeIssue(issue.getId());
    }

}
