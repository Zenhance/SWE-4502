package command;
import model.Comment;
import model.Issue;
import repository.IssueRepository;
import service.NotificationService;

public class AddCommentCommand extends AbstractCommand {
    private final IssueRepository repository;
    private final String issueId;
    private final String content;
    private final String author;
    private Comment addedComment;
    private final NotificationService notificationService;

    public AddCommentCommand(IssueRepository repository, String issueId,
                             String content, String author, NotificationService notificationService) {
        super(CommandType.Update);
        this.repository = repository;
        this.issueId = issueId;
        this.content = content;
        this.author = author;
        this.notificationService = notificationService;
    }

    @Override
    public void execute() {
        Issue issue = repository.findById(issueId);
        if (issue != null) {
            addedComment = new Comment(content, author);
            issue.addComment(addedComment);
            repository.save(issue);

            if (notificationService != null) {
                notificationService.notifyCommentAdded(issue, addedComment);
            }
        }
    }

    @Override
    public void undo() {
        if (addedComment != null) {
            Issue issue = repository.findById(issueId);
            if (issue != null) {
                issue.removeComment(addedComment.getId());
                repository.save(issue);

                if (notificationService != null) {
                    notificationService.notifyCommentRemoved(issue, addedComment);
                }
            }
        }
    }

    @Override
    public String getDescription() {
        return "Added comment to issue " + issueId + " by " + author;
    }
}