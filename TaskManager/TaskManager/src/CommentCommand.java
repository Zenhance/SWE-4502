public class CommentCommand implements Command{
    private Issue issue;
    private Comment comment;
    public CommentCommand(Issue issue,Comment comment){
        this.issue=issue;
        this.comment=comment;
    }
    public void execute(){
        issue.addComment(comment);
    }
}