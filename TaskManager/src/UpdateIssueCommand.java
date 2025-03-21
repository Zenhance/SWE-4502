public class UpdateIssueCommand implements Command {
    private IssueRepository repository;
    private Issue issue;
    private String newTitle;
    private String newDescription;
    private String oldTitle;
    private String oldDescription;
    public UpdateIssueCommand(IssueRepository repository, Issue issue, String
            newTitle, String newDescription) {
        this.repository = repository;
        this.issue = issue;
        this.newTitle = newTitle;
        this.newDescription = newDescription;
    }
    @Override
    public void execute() {
        oldTitle = issue.getTitle();
        oldDescription = issue.getDescription();
        issue.setTitle(newTitle);
        issue.setDescription(newDescription);
    }
    @Override
    public void undo() {
        issue.setTitle(oldTitle);
        issue.setDescription(oldDescription);
    }
}