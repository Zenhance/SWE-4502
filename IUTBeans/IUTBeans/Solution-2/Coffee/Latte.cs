using IUTBeans.Solution_2.Condiments;

namespace IUTBeans.Solution_2.Coffee;

public class Latte:ICoffee
{
    private readonly ICondiment? _condiment;

    public  Latte(ICondiment? condiment)
    {
        _condiment = condiment;
    }

    public string GetDescription()
    {
        return "Latte " + (_condiment == null ? "." : _condiment.GetDescription());
    }

    public double GetPrice()
    {
        return 240.0 + (_condiment?.GetPrice() ?? 0);
    }
}