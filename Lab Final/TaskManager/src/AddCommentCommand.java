public class AddCommentCommand implements Command{
    private IssueService issueService;
    private int issueId;
    private String content;
    private String author;
    private Comment addedComment;

    public AddCommentCommand(IssueService issueService, int issueId, String content, String author) {
        this.issueService = issueService;
        this.issueId = issueId;
        this.content = content;
        this.author = author;
    }

    @Override
    public void execute() {
        

    }

    @Override
    public void undo() {

    }

    public Comment getAddedComment() {
        return addedComment;
    }
}


