using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Lab4_IUTBeans
{
    class Program
    {
        static void Main(string[] args)
        {
            // Get user's beverage choice
            Beverage beverage = GetBeverageChoice();

            // Keep adding condiments until the user is satisfied
            bool moreCondiments = true;
            while (moreCondiments)
            {
                Console.WriteLine("Would you like to add a condiment?");
                Console.WriteLine("1: Milk ($50), 2: Sugar ($25), 3: Whipped Cream ($75), 0: No more condiments");

                int condimentChoice = int.Parse(Console.ReadLine());
                switch (condimentChoice)
                {
                    case 1:
                        beverage = new CondimentDecorator(beverage, new Milk());
                        break;
                    case 2:
                        beverage = new CondimentDecorator(beverage, new Sugar());
                        break;
                    case 3:
                        beverage = new CondimentDecorator(beverage, new WhippedCream());
                        break;
                    case 0:
                        moreCondiments = false; 
                        break;
                    default:
                        Console.WriteLine("Invalid choice. Please try again.");
                        break;
                }
            }

            // Display the final order
            Console.WriteLine("Your order: " + beverage.GetDescription() + " $" + beverage.Cost());
            Console.ReadLine();
        }

        static Beverage GetBeverageChoice()
        {
            Console.WriteLine("Welcome to IUTBeans Coffee Shop!");
            Console.WriteLine("Please choose a beverage:");
            Console.WriteLine("1: Espresso ($200), 2: Latte ($300), 3: Cappuccino ($350)");

            int choice = int.Parse(Console.ReadLine());
            switch (choice)
            {
                case 1:
                    return new Espresso();
                case 2:
                    return new Latte();
                case 3:
                    return new Cappuccino();
                default:
                    Console.WriteLine("Invalid choice. Defaulting to Espresso.");
                    return new Espresso(); 
            }
        }
    }
}
