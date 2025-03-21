public class CreateIssue implements Command{
    private Receiver r;
    IssueRepository r1;
    public CreateIssue(Receiver r)
    {
        this.r=r;

    }
    @Override
    public void execute() {
        r.CreateIssue(r1);
    }
}
