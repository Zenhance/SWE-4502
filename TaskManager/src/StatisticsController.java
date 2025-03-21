
public class  StatisticsController implements Command{
    private Receiver r;
    public  StatisticsController(Receiver r)
    {
        this.r=r;
    }
    @Override
    public void execute() {
        r.StatisticController();
    }
}