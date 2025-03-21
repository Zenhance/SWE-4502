public class UpdateCommand implements Command{
    Issue issue;
    String title;
    Enum<PRIORITY> priority;
    public UpdateCommand(Issue issue,String title, Enum<PRIORITY> priority) {
        this.issue =issue;
        this.title = title;
        this.priority = priority;
    }

    @Override
    public void execute() {
        issue.updateIssue(title,priority);
    }
}
