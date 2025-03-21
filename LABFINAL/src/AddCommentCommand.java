public class AddCommentCommand implements Command{
    private Issue issue;
    private Comment comment;

    public AddCommentCommand(Issue issue, Comment comment) {
        this.issue = issue;
        this.comment = comment;
    }

    public void execute() { issue.addComment(comment); }
    public void undo() {   issue.addComment(comment);}
}
