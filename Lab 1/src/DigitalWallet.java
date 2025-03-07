public class DigitalWallet implements PaymentMethod {
    private String walletId;

    public DigitalWallet(String walletId) {
        this.walletId = walletId;
    }

    @Override
    public void processPayment(double amount) {
        System.out.println("Processing digital wallet payment of BDT " + amount + " for wallet ID: " + walletId);
    }
}
