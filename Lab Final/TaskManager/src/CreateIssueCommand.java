public class CreateIssueCommand implements Command {
    private IssueService issueService;
    private String title;
    private String description;
    private String priority;
    private Issue createdIssue;

    public CreateIssueCommand(IssueService issueService, String title, String description, String priority) {
        this.issueService = issueService;
        this.title = title;
        this.description = description;
        this.priority = priority;
    }

    @Override
    public void execute() {
        createdIssue = issueService.createIssue(title, description, priority);
    }

    @Override
    public void undo() {
        if (createdIssue != null) {
            issueService.deleteIssue(createdIssue.ID);
        }
    }

    public Issue getCreatedIssue() {
        return createdIssue;
    }
}