public class PaypalPayment implements PaymentMethod{
    @Override
    public void pay(int dollars) {
        System.out.println("Paying " + dollars + " using Paypal.");
    }
}
