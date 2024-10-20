using IUTBeans.Solution_2.Condiments;

namespace IUTBeans.Solution_2.Coffee;

public class Americano:ICoffee
{
    private readonly ICondiment? _condiment;

    public  Americano(ICondiment? condiment)
    {
        _condiment = condiment;
    }

    public string GetDescription()
    {
        return "Americano " + (_condiment == null ? "." : _condiment.GetDescription());
    }

    public double GetPrice()
    {
        return 100.0 + (_condiment == null ? 0 : _condiment.GetPrice());
    }
}