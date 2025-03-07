package Payment;

public class CashPayment implements Payment {

    public CashPayment() {

    }

    @Override
    public void pay(double amount) {
        System.out.println("Paid " + amount +" Through Cash!");
    }
}
