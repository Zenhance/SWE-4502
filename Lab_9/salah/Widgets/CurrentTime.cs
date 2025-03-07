using salah.Mediator;

namespace salah.Widgets;

public class CurrentTime : IWidget
{
    private DateTime time;

    private WidgetMediator _mediator;

    public CurrentTime(WidgetMediator mediator)
    {
        _mediator = mediator;
    }

    public void update()
    {
        Console.WriteLine("Current Time Updated");
        _mediator.Notify(this);
    }
}