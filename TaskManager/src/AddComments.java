public class AddComments implements Command{
    public Comment c;

    public Issue issue;
    public  AddComments(Issue issue, Comment c) {
        this.issue = issue;
        issue.addComment(c);

    }

    @Override
    public void execute() {
       new AddComments(issue,c);
    }
}
