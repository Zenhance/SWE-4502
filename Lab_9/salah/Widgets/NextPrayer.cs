using salah.Mediator;

namespace salah.Widgets;

public class NextPrayer : IWidget
{
    private string _NextPrayer;
    private WidgetMediator _mediator;

    public NextPrayer(string nextPrayer)
    {
        _NextPrayer = nextPrayer;
    }

    public NextPrayer(WidgetMediator mediator)
    {
        _mediator = mediator;
    }

    public void update()
    {
        Console.WriteLine("Next Prayer Has Been Updated");
        _mediator.Notify(this);
    }

}