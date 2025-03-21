public class AddCommentCommand implements Command {
    private IssueRepository repository;
    private Issue issue;
    private Comment comment;
    public AddCommentCommand(IssueRepository repository, Issue issue, Comment comment) {
        this.repository = repository;
        this.issue = issue;
        this.comment = comment;
    }
    @Override
    public void execute() {
        issue.addComment(comment);
    }
    @Override
    public void undo() {
// Code to remove the last comment
    }
}