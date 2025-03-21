public class CreateIssue implements Command{
    private Receiver r;
    public CreateIssue(Receiver r)
    {
        this.r=r;
    }
    @Override
    public void execute() {
        r.CreateIssue();
    }
}
