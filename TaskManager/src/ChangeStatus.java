
public class ChangeStatus implements Command{
    private Receiver r;
    public ChangeStatus(Receiver r)
    {
        this.r=r;
    }
    @Override
    public void execute() {
        r.ChangeStatus();
    }
}