using IUTBeans.Solution_1.Coffee;

namespace IUTBeans.Solution_1.Condiments;

public class WhiteSugar:CondimentDecorator
{
    public WhiteSugar(ICoffee coffee) : base(coffee)
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