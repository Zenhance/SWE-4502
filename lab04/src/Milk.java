public class Milk extends IngrediantsDecorator{
    public Milk(Beverage beverage)
    {
        super(beverage);
    }
    public String getDescription()
    {
        return beverage.getDescription() + ", Milk";
    }
    public double cost()
    {
        return beverage.cost() + 0.50;
    }
}
