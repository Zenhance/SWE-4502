public class UpdateIssueCommand implements Command{
    private IssueRepository repository;
    private Issue issue;
    private String newTitle;
    private String newDescription;

    public UpdateIssueCommand(IssueRepository repository, Issue issue, String newTitle, String newDescription) {
        this.repository = repository;
        this.issue = issue;
        this.newTitle = newTitle;
        this.newDescription = newDescription;
    }

    @Override
    public void execute()
    {
        issue.setTitle(newTitle);
        issue.setDescription((newDescription));
    }

    @Override
    public void undo()
    {
        System.out.println("tuli undo the update here!!");
    }

}
