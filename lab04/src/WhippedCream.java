public class WhippedCream extends IngrediantsDecorator{
    public WhippedCream(Beverage beverage)
    {
        super(beverage);
    }
    public String getDescription()
    {
        return beverage.getDescription() + ", Whipped Cream";
    }
    public double cost()
    {
        return beverage.cost() + 0.75;
    }
}
