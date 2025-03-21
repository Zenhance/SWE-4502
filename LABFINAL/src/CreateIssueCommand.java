public class CreateIssueCommand implements Command{
    private Issue issue;
    private IssueRepository repo;

    public CreateIssueCommand(IssueRepository repo, Issue issue) {
        this.repo = repo;
        this.issue = issue;
    }

    public void execute() { repo.addIssue(issue); }
    public void undo() { repo.removeIssue(issue); }
    public String getDescription() {
        return "description";
    }
}
