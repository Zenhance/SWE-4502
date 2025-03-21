public class AddComments implements Command{
    private Receiver r;
    Comment c;
    public AddComments(Receiver r)
    {
        this.r=r;
    }
    @Override
    public void execute() {
        r.Addcomments(c);
    }
}
