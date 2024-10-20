using IUTBeans.Solution_2.Condiments;

namespace IUTBeans.Solution_2.Coffee;

public class Espresso:ICoffee
{
    private readonly ICondiment? _condiment;

    public  Espresso(ICondiment? condiment)
    {
        _condiment = condiment;
    }

    public string GetDescription()
    {
        return "Espresso " + (_condiment == null ? "." : _condiment.GetDescription());
    }

    public double GetPrice()
    {
        return 200.0 + (_condiment?.GetPrice() ?? 0);
    }
}