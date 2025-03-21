package command;
import model.Issue;
import model.Priority;
import repository.IssueRepository;
import service.NotificationService;

public class UpdateIssueCommand extends AbstractCommand {
    private final IssueRepository repository;
    private final String issueId;
    private final String newTitle;
    private final String newDescription;
    private final Priority newPriority;
    private final String newAssignedTo;

    private String oldTitle;
    private String oldDescription;
    private Priority oldPriority;
    private String oldAssignedTo;
    private final NotificationService notificationService;

    public UpdateIssueCommand(IssueRepository repository, String issueId,
                              String newTitle, String newDescription, Priority newPriority,
                              String newAssignedTo, NotificationService notificationService) {
        super(CommandType.Update);
        this.repository = repository;
        this.issueId = issueId;
        this.newTitle = newTitle;
        this.newDescription = newDescription;
        this.newPriority = newPriority;
        this.newAssignedTo = newAssignedTo;
        this.notificationService = notificationService;
    }

    @Override
    public void execute() {
        Issue issue = repository.findById(issueId);
        if (issue != null) {
            oldTitle = issue.getTitle();
            oldDescription = issue.getDescription();
            oldPriority = issue.getPriority();
            oldAssignedTo = issue.getAssignedTo();

            if (newTitle != null) issue.setTitle(newTitle);
            if (newDescription != null) issue.setDescription(newDescription);
            if (newPriority != null) issue.setPriority(newPriority);
            if (newAssignedTo != null) issue.setAssignedTo(newAssignedTo);

            repository.save(issue);

            if (notificationService != null) {
                notificationService.notifyIssueUpdated(issue);
            }
        }
    }

    @Override
    public void undo() {
        Issue issue = repository.findById(issueId);
        if (issue != null) {
            issue.setTitle(oldTitle);
            issue.setDescription(oldDescription);
            issue.setPriority(oldPriority);
            issue.setAssignedTo(oldAssignedTo);

            repository.save(issue);

            if (notificationService != null) {
                notificationService.notifyIssueUpdated(issue);
            }
        }
    }

    @Override
    public String getDescription() {
        return "Updated issue: " + issueId;
    }
}
