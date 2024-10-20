namespace IUTBeans.Solution_2.Condiments;

public class Milk:ICondiment
{
    private ICondiment? _condiment;
    public Milk(ICondiment? condiment)
    {
        _condiment = condiment;
    }
    public string GetDescription()
    {
        return "with Milk " + (_condiment?.GetDescription() ?? ".");
    }

    public double GetPrice()
    {
        return 50 + (_condiment?.GetPrice() ?? 0);
    }
}