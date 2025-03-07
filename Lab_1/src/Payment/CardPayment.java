package Payment;

public class CardPayment implements Payment {

    public int cardNumber;
    public String cardHolderName;

    public CardPayment(int cardNumber, String cardHolderName){
        this.cardNumber = cardNumber;
        this.cardHolderName = cardHolderName;
    }

    @Override
    public void pay(double amount) {
        System.out.println("Paid " + amount +" Through Card! Card Number: " + cardNumber + " Card Holder Name: " + cardHolderName);
    }
}
