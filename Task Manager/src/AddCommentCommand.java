public class AddCommentCommand implements Command {
    private Issue issue;
    private Comment comment;
    private IssueRepository issueRepository;

    public AddCommentCommand(Issue issue, Comment comment, IssueRepository issueRepository) {
        this.issue = issue;
        this.comment = comment;
        this.issueRepository = issueRepository;
    }

    @Override
    public void execute() {
        issue.addComment(comment);
        issueRepository.updateIssue(issue);
    }

    @Override
    public void undo() {
        issue.removeComment(comment);
        issueRepository.updateIssue(issue);
    }
}