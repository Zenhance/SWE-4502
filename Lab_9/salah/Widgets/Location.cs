using salah.Mediator;

namespace salah.Widgets;

public class Location : IWidget
{
    private double _lat;
    private double _lon;

    private WidgetMediator _mediator;

    public Location(double lat, double lon)
    {
        _lat = lat;
        _lon = lon;
    }

    public Location(WidgetMediator mediator)
    {
        _mediator = mediator;

    }

    public void update()
    {
        Console.WriteLine("Location Has Been Updated");
        _mediator.Notify(this);
    }
}