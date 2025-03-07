using salah.Mediator;

namespace salah.Widgets;

public class CurrentWaqt : IWidget
{
    private string _waqt;

    private WidgetMediator _mediator;

    public CurrentWaqt(string waqt)
    {
        _waqt = waqt;
    }

    public CurrentWaqt(WidgetMediator mediator)
    {
        _mediator = mediator;
    }

    public void update()
    {
        Console.WriteLine("Current Waqt has been updated");
        _mediator.Notify(this);
    }
}