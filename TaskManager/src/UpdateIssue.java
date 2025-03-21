public class UpdateIssue implements Command{
    private Receiver r;
    String d;
    public UpdateIssue(Receiver r)
    {
        this.r=r;
    }
    @Override
    public void execute() {
        r.UpdateIssue(d);
    }
}