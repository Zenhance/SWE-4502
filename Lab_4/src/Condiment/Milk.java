package Condiment;

public class Milk implements ICondiment {
    private ICondiment nextCondiment;

    public Milk(ICondiment nextCondiment){
        this.nextCondiment = nextCondiment;
    }
    public double getPrice(){
        return 10 + nextCondiment.getPrice();
    }
}

