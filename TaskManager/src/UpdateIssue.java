public class UpdateIssue implements Command{
    private Receiver r;
    public UpdateIssue(Receiver r)
    {
        this.r=r;
    }
    @Override
    public void execute() {
        r.UpdateIssue();
    }
}