package Condiment;

public class WhippedCream implements ICondiment {

    private ICondiment nextCondiment;

    public WhippedCream(ICondiment nextCondiment){
        this.nextCondiment = nextCondiment;
    }

    public double getPrice(){
        return 15 + nextCondiment.getPrice();
    }
}
