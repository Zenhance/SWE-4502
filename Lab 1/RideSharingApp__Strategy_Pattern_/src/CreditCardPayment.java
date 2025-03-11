public class CreditCardPayment implements IPaymentMethod {
    private int CardNumber;
    private String CardHolderName;

    // Constructor
    public CreditCardPayment(int cardNumber, String cardHolderName) {
        this.CardNumber = cardNumber;
        this.CardHolderName = cardHolderName;
    }
    public int getCardNumber() {
        return CardNumber;
    }

    public String getCardHolderName() {
        return CardHolderName;
    }

    @Override
    public void ProcessPayment(double amount) {
        System.out.println("Processing credit card payment of " + amount);
        System.out.println("Card Number: " + CardNumber + ", Card Holder: " + CardHolderName);
    }
}

