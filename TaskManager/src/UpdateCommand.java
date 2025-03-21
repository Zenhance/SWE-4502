public class UpdateCommand implements Command{
    Issue issue;
    Issue prev_Issue;
    String title;

    Comment comment;
    Enum<PRIORITY> priority;
    public UpdateCommand(Issue issue,String title, Enum<PRIORITY> priority) {
        this.issue =issue;
        this.title = title;
        this.priority = priority;
    }

    public UpdateCommand(Issue issue, Comment comment) {
        this.issue = issue;
        this.comment = comment;
    }

    @Override
    public Issue execute() {
        prev_Issue = issue;

        if(title!= null && priority!= null)
            issue = issue.updateIssue(title,priority);
        if(comment!= null)
            issue = issue.updateIssue(comment);

        return issue;
    }

    @Override
    public Issue undo() {
        issue = prev_Issue;
        return issue;
    }
}
