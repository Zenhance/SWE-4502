public class AddComments implements Command{
    private Receiver r;
    public AddComments(Receiver r)
    {
        this.r=r;
    }
    @Override
    public void execute() {
        r.Addcomments();
    }
}
