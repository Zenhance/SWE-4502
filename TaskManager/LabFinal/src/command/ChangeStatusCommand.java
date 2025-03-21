package command;
import model.Issue;
import model.Status;
import repository.IssueRepository;
import service.NotificationService;

public class ChangeStatusCommand extends AbstractCommand {
    private final IssueRepository repository;
    private final String issueId;
    private final Status newStatus;
    private Status oldStatus;
    private final NotificationService notificationService;

    public ChangeStatusCommand(IssueRepository repository, String issueId,
                               Status newStatus, NotificationService notificationService) {
        super(CommandType.Update);
        this.repository = repository;
        this.issueId = issueId;
        this.newStatus = newStatus;
        this.notificationService = notificationService;
    }

    @Override
    public void execute() {
        Issue issue = repository.findById(issueId);
        if (issue != null) {
            oldStatus = issue.getStatus();
            issue.setStatus(newStatus);
            repository.save(issue);

            if (notificationService != null) {
                notificationService.notifyStatusChanged(issue, oldStatus, newStatus);
            }
        }
    }

    @Override
    public void undo() {
        Issue issue = repository.findById(issueId);
        if (issue != null && oldStatus != null) {
            Status currentStatus = issue.getStatus();
            issue.setStatus(oldStatus);
            repository.save(issue);

            if (notificationService != null) {
                notificationService.notifyStatusChanged(issue, currentStatus, oldStatus);
            }
        }
    }

    @Override
    public String getDescription() {
        return "Changed status of issue " + issueId + " from " + oldStatus  + " to " + newStatus;
    }
}
