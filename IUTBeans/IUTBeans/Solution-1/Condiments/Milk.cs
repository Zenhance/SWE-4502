using IUTBeans.Solution_1.Coffee;
using IUTBeans.Solution_2.Condiments;

namespace IUTBeans.Solution_1.Condiments;

public class Milk:CondimentDecorator
{
    public Milk(ICoffee coffee) : base(coffee)
    {
    }

    public Milk(CondimentDecorator condimentDecorator) : base(condimentDecorator)
    {
    }

    public override string GetDescription()
    {
        throw new NotImplementedException();
    }

    public override double GetPrice()
    {
        throw new NotImplementedException();
    }
}