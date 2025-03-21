import java.time.LocalDateTime;

public class CreateIssueCommand implements Command {
    private IssueRepository repo;
    private Issue issue;
    private Logger logger;
    private NotificationService notifier;
    private StatisticsCollector stats;
    private final LocalDateTime timestamp = LocalDateTime.now();

    public CreateIssueCommand(IssueRepository repo, Issue issue, Logger logger, NotificationService notifier, StatisticsCollector stats) {
        this.repo = repo;
        this.issue = issue;
        this.logger = logger;
        this.notifier = notifier;
        this.stats = stats;
    }

    @Override
    public void execute() {
        repo.addIssue(issue);
        logger.log("Created issue: " + issue.getId());
        notifier.notifyAllObservers("New issue created: " + issue.getTitle());
        stats.increment(CommandType.CREATE);
    }

    @Override
    public void undo() {
        repo.removeIssue(issue.getId());
        logger.log("Undo create issue: " + issue.getId());
    }

    @Override
    public String getDescription() {
        return "CreateIssueCommand for ID " + issue.getId();
    }

    @Override
    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    @Override
    public CommandType getType() {
        return CommandType.CREATE;
    }
}
