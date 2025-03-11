public class CondimentedBevarage extends Beverage
{
    private Beverage beverage;
    private ICondiment condiment;

    public CondimentedBevarage(Beverage beverage, ICondiment condiment)
    {
        this.beverage = beverage;
        this.condiment = condiment;
    }

    @Override
    public String GetDescription()
    {
    return beverage.GetDescription() + ", " + condiment.GetCondimentDescription();
    }

    @Override
    public double Cost()
    {
    return beverage.Cost() + condiment.GetCondimentCost();
    }
}
