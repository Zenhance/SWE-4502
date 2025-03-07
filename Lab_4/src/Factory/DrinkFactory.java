package Factory;

import Drink.Coffee;
import Drink.Espresso;
import Drink.Idrink;
import Drink.Latte;

import java.util.HashMap;
import java.util.Map;

public class DrinkFactory {
    private Map<String, Idrink> drinks = new HashMap<>();
    public DrinkFactory(){
        drinks.put("1", new Latte());
        drinks.put("2", new Espresso());
        drinks.put("3", new Coffee());
    }

    public Idrink getDrink(String drinkType){
        return drinks.get(drinkType);
    }

    public void Signature(){
        String Signature = "Write the followings to get the drinks: \n"
                + "1 for Latte\n"
                + "2 for Espresso\n"
                + "3 for Coffee\n";

        System.out.println(Signature);
    }
}
