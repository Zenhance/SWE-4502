using salah.Mediator;

namespace salah.Widgets;

public class TimeZone : IWidget
{
    private double _offset;
    private WidgetMediator _mediator;

    public TimeZone(double offset)
    {
        _offset = offset;
    }

    public TimeZone(WidgetMediator mediator)
    {
        _mediator = mediator;
    }

    public void update()
    {
        Console.WriteLine("TimeZone has been updated");
        _mediator.Notify(this);
    }
    
    
}