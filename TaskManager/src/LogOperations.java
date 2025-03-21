public class LogOperations implements Command{
    private Receiver r;
    public LogOperations(Receiver r)
    {
        this.r=r;
    }
    @Override
    public void execute() {
        r.LogOperation();
    }
}