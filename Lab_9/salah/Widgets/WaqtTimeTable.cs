using salah.Mediator;

namespace salah.Widgets;

public class WaqtTimeTable : IWidget
{

    private Dictionary<string, DateTime> _TimeTable;
    private WidgetMediator _mediator;
    

    public WaqtTimeTable(WidgetMediator mediator)
    {
        _mediator = mediator;
    }

    public void update()
    {
        Console.WriteLine("Waqt Time Table Has been Updated");
        _mediator.Notify(this);
    }
}