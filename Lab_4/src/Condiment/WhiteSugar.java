package Condiment;

public class WhiteSugar implements ICondiment {

    private ICondiment nextCondiment;

    public WhiteSugar(ICondiment nextCondiment){
        this.nextCondiment = nextCondiment;
    }

    public double getPrice(){
        return 5 + nextCondiment.getPrice();
    }
}
