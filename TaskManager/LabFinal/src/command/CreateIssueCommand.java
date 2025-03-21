package command;
import model.Issue;
import model.Priority;
import repository.IssueRepository;
import service.NotificationService;

public class CreateIssueCommand extends AbstractCommand {
    private final IssueRepository repository;
    private final String title;
    private final String description;
    private final Priority priority;
    private Issue createdIssue;
    private final NotificationService notificationService;

    public CreateIssueCommand(IssueRepository repository, String title, String description,
                              Priority priority, NotificationService notificationService) {
        super(CommandType.Create);
        this.repository = repository;
        this.title = title;
        this.description = description;
        this.priority = priority;
        this.notificationService = notificationService;
    }

    @Override
    public void execute() {
        createdIssue = new Issue(title, description, priority);
        repository.save(createdIssue);

        if (notificationService != null) {
            notificationService.notifyIssueCreated(createdIssue);
        }
    }

    @Override
    public void undo() {
        if (createdIssue != null) {
            repository.delete(createdIssue.getId());

            if (notificationService != null) {
                notificationService.notifyIssueDeleted(createdIssue);
            }
        }
    }

    @Override
    public String getDescription() {
        return "Created issue: " + title;
    }

    public String getIssueId() {
        return createdIssue.getId();
    }
}