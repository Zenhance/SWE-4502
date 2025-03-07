public class Suger extends IngrediantsDecorator{
    public Suger(Beverage beverage)
    {
        super(beverage);
    }
    public String getDescription()
    {
        return beverage.getDescription() + ", Suger";
    }
    public double cost()
    {
        return beverage.cost() + 0.25;
    }
}
