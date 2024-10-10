using IUTBeans.Solution_1.Coffee;

namespace IUTBeans.Solution_1.Condiments;

public abstract class CondimentDecorator
{
    protected ICoffee _coffee;
    protected CondimentDecorator _condimentDecorator;
    public CondimentDecorator(ICoffee coffee)
    {
        _coffee = coffee;
    }

    public CondimentDecorator(CondimentDecorator condimentDecorator)
    {
        _condimentDecorator = condimentDecorator;
    }

    public abstract string GetDescription();
    public abstract double GetPrice();
}