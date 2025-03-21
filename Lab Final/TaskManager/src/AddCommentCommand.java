public class AddCommentCommand implements Command{
    private IssueService issueService;
    private int issueId;
    private String content;
    private String author;
    private Issue addedComment;

    public AddCommentCommand(IssueService issueService, int issueId, String content, String author) {
        this.issueService = issueService;
        this.issueId = issueId;
        this.content = content;
        this.author = author;
    }

    @Override
    public void execute() {
        addedComment = issueService.addComment(issueId, content, author);
    }

    @Override
    public void undo() {

    }

    public Issue getAddedComment() {
        return addedComment;
    }
}


