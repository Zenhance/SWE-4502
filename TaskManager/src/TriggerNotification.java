public class TriggerNotification  implements Command{
    private Receiver r;
    public TriggerNotification (Receiver r)
    {
        this.r=r;
    }
    @Override
    public void execute() {
        r.TriggerNotification();
    }
}
