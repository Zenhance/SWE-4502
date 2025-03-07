import java.util.Scanner;
public class Main {

    public static void main(String[] args) {
        Beverage beverage = getBeverageChoice();

        boolean moreCondiments = true;
        Scanner scanner = new Scanner(System.in);

        while (moreCondiments) {
            System.out.println("Would you like to add a condiment?");
            System.out.println("1: Milk ($50), 2: Sugar ($25), 3: Whipped Cream ($75), 0: No more condiments");

            int condimentChoice = Integer.parseInt(scanner.nextLine());
            switch (condimentChoice) {
                case 1:
                    beverage = new CondimentedBevarage(beverage, new Milk());
                    break;
                case 2:
                    beverage = new CondimentedBevarage(beverage, new Sugar());
                    break;
                case 3:
                    beverage = new CondimentedBevarage(beverage, new WhippedCream());
                    break;
                case 0:
                    moreCondiments = false;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }

        System.out.println("Your order: " + beverage.GetDescription() + " $" + beverage.Cost());
        scanner.close();
    }

    public static Beverage getBeverageChoice() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to IUTBeans Coffee Shop!");
        System.out.println("Please choose a beverage:");
        System.out.println("1: Espresso ($200), 2: Latte ($300), 3: Cappuccino ($350)");

        int choice = Integer.parseInt(scanner.nextLine());
        switch (choice) {
            case 1:
                return new Espresso();
            case 2:
                return new Latte();
            case 3:
                return new Cappuccino();
            default:
                System.out.println("Invalid choice. Defaulting to Espresso.");
                return new Espresso();
        }
    }
}
