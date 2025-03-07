abstract public class IngrediantsDecorator {
    Beverage beverage;
    public IngrediantsDecorator(Beverage beverage)
    {
        this.beverage = beverage;

    }
    public String getDescription()
    {
        return beverage.getDescription();

    }
    public double cost()
    {
        return beverage.cost();

    }
}
