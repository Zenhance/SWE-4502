using salah.Mediator;

namespace salah.Widgets;

public class PrayerTimeTable : IWidget
{
    private Dictionary<string, DateTime> _TimeTable;
    private WidgetMediator _mediator;

    public PrayerTimeTable(Dictionary<string, DateTime> TimeTable)
    {
        _TimeTable = TimeTable;
    }

    public PrayerTimeTable(WidgetMediator mediator)
    {
        _mediator = mediator;
    }

    public void update()
    {
        Console.WriteLine("Prayer Time Table has been updated");
        _mediator.Notify(this);
    }
}