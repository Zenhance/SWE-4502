public class CreateIssue implements Command{

    IssueRepository repository;

    Issue issue;

    public CreateIssue(IssueRepository repository, Issue issue){
        this.repository=repository;
        this.issue=issue;
    }

    @Override
    public void execute() {
        repository.addIssue(issue);
    }

    @Override
    public void undo() {
        repository.removeIssue(issue.getId());
    }


}
