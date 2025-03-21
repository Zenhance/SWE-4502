public class AddComment implements Command{

    IssueRepository repository;

    Issue issue;

    Comment comment;

    public AddComment(IssueRepository repository, Issue issue, Comment comment){
        this.repository=repository;
        this.issue=issue;
        this.comment=comment;
    }

    @Override
    public void execute() {
        repository.AddComment(issue.getId(), comment);
    }

    @Override
    public void undo() {
        repository.removeComment(issue.getId(), comment.getId());
    }


}
