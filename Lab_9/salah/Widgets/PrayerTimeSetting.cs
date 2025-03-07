using salah.Mediator;

namespace salah.Widgets;

public class PrayerTimeSetting : IWidget
{
    private Dictionary<string, DateTime> _TimeTable;
    private WidgetMediator _mediator;

    public PrayerTimeSetting(Dictionary<string, DateTime> TimeTable)
    {
        _TimeTable = TimeTable;
    }

    public PrayerTimeSetting(WidgetMediator mediator)
    {
        _mediator = mediator;
    }

    public void update()
    {
        Console.WriteLine("Prayer Time Setting Has Been Updated");
        _mediator.Notify(this);
    }
}