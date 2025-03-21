public class UpdateIssueCommand implements Command{

    private Issue issue;
    private IssueRepository repository;

    @Override
    public void execute(){
        System.out.println("Issue has been updated");
    }

    @Override
    public void undo() {
        repository.getIssue(issue.getId());
    }

}
