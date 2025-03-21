public class CreateIssueCommand implements ICommand {


    private final IssueRepo repository;
    private final Issue issue;
    private final Notification notificationService;

    public CreateIssueCommand(IssueRepo repository, Issue issue, Notification
            notificationService) {
        this.repository = repository;
        this.issue = issue;
        this.notificationService = notificationService;
    }

    @Override
    public void execute() {
        repository.addIssue(issue);
        notificationService.notifyObservers("Issue Created: " + issue.getTitle());
    }


    @Override
    public void undo() {
        repository.remove(issue.getId());
        notificationService.notifyObservers("Issue Removed: " + issue.getTitle());
    }

}
