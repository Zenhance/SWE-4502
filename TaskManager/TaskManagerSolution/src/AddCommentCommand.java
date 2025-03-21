import java.util.List;

public class AddCommentCommand extends Command{
    private final IssueRepository repository;
    private final String issueId;
    private final Comment comment;

    public AddCommentCommand(IssueRepository repository, String issueId, Comment comment) {
        super("Added comment to issue", CommandType.UPDATE);
        this.repository = repository;
        this.issueId = issueId;
        this.comment = comment;
    }

    @Override
    public void execute() {
        Issue issue = repository.getIssue(issueId);
        issue.addComment(comment);
    }

    @Override
    public void undo() {
        Issue issue = repository.getIssue(issueId);
        List<Comment> comments = issue.getComments();
        if (!comments.isEmpty()) {
            comments.remove(comment);
        }
    }

}
