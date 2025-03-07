public class CardPayment implements PaymentMethod{
    @Override
    public void pay(int dollars) {
        System.out.println("Paying " + dollars + " using card.");
    }
}
