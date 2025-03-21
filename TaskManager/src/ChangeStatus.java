
public class ChangeStatus implements Command{
    private Receiver r;
    Priority p;
    public ChangeStatus(Receiver r)
    {
        this.r=r;
    }
    @Override
    public void execute() {
        r.ChangeStatus(p);
    }
}