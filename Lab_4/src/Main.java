import Condiment.ICondiment;
import Drink.Idrink;
import Factory.CondFactory;
import Factory.DrinkFactory;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        DrinkFactory drinkFactory = new DrinkFactory();
        CondFactory condFactory = new CondFactory();

        drinkFactory.Signature();
        System.out.println("Enter the drink you want: ");
        Scanner scanner = new Scanner(System.in);
        String drinkType = scanner.nextLine();
        Idrink drink = drinkFactory.getDrink(drinkType);

        double price = drink.getPrice();

        condFactory.Signature();
        System.out.println("Enter the condiment serially you want: ");
        String condTypes = scanner.nextLine();

        int contTypeLength = condTypes.length();

        for(int i=0; i<contTypeLength; i++){
            String condType = String.valueOf(condTypes.charAt(i));
            ICondiment cond = condFactory.getCond(condType);
            price += cond.getPrice();
        }

        System.out.println("The total price is: " + price);
    }
}