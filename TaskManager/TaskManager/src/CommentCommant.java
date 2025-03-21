public class CommentCommand implements Command{
    private Issue issue;
    private Comment comment;
    public CommentCommand{
        this.issue=issue;
        this.comment=comment;
    }
    public void execute(){
        issue.addComment(comment);
    }
}