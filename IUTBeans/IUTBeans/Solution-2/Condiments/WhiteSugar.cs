namespace IUTBeans.Solution_2.Condiments;

public class WhiteSugar:ICondiment
{
    private ICondiment? _condiment;
    public WhiteSugar(ICondiment? condiment)
    {
        _condiment = condiment;
    }
    public string GetDescription()
    {
        return "with White sugar " + (_condiment?.GetDescription() ?? ".");
    }

    public double GetPrice()
    {
        return 5 + (_condiment?.GetPrice() ?? 0);
    }
}