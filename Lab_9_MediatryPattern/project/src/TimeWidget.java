import java.awt.desktop.SystemEventListener;

public class TimeWidget extends  WidgetComponent
{
    private String currentTime;

    public TimeWidget(Mediator mediator)
    {
        super(mediator);
    }

    public void updateTime(String time)
    {
        this.currentTime=time;
        System.out.println("Updated time: "+ currentTime);
        mediator.notify("TimeUpdated");
    }

    public String getCurrentTime()
    {
        return currentTime;
    }


}
