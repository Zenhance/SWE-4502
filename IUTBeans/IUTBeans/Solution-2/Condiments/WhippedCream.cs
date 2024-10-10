namespace IUTBeans.Solution_2.Condiments;

public class WhippedCream:ICondiment
{
    private ICondiment? _condiment;

    public WhippedCream(ICondiment? condiment)
    {
        _condiment = condiment;
    }
    public string GetDescription()
    {
        return "with Whipped cream " + (_condiment?.GetDescription() ?? ".");
    }

    public double GetPrice()
    {
        return 75 + (_condiment?.GetPrice() ?? 0);
    }
}