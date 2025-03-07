package Factory;

import java.util.HashMap;
import java.util.Map;
import Condiment.*;

public class CondFactory {

    private Map<String, ICondiment> conds = new HashMap<>();

    public CondFactory(){
        conds.put("1", new Milk(new WhiteSugar(new WhippedCream(new blank()))));
        conds.put("2", new WhiteSugar(new WhiteSugar(new Milk(new blank()))));
        conds.put("3", new WhippedCream(new Milk(new Milk(new blank()))));
    }

    public ICondiment getCond(String condType){
        return conds.get(condType);
    }

    public void Signature(){
        String Signature = "Write the followings to get the condiments: \n"
                + "1 for Milk + white sugar + Whipped Cream\n"
                + "2 for WhiteSugar * 2 + milk\n"
                + "3 for WhippedCream + milk * 2\n";

        System.out.println(Signature);
    }
}
