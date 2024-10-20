using IUTBeans.Solution_2.Coffee;
using IUTBeans.Solution_2.Condiments;

var americanoWithWhiteSugar = new Americano(new Milk(new WhiteSugar(null)));
Console.WriteLine(americanoWithWhiteSugar.GetDescription());
Console.WriteLine(americanoWithWhiteSugar.GetPrice());

var espressoWithMilkAndWhippedCream = new Espresso(new Milk(new WhippedCream(null)));
Console.WriteLine(espressoWithMilkAndWhippedCream.GetDescription());
Console.WriteLine(espressoWithMilkAndWhippedCream.GetPrice());

var latteWithWhippedCream = new Latte(new WhippedCream(null));
Console.WriteLine(latteWithWhippedCream.GetDescription());
Console.WriteLine(latteWithWhippedCream.GetPrice());