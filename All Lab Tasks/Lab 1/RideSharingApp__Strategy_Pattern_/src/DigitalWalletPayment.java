public class DigitalWalletPayment implements IPaymentMethod
{
    public String WalletId;
    public int Otp;
    public DigitalWalletPayment(String walletId, int otp)
    {
        WalletId = walletId;
        Otp = otp;
    }

    public void ProcessPayment(double amount)
    {

            System.out.println("Processing Digital Wallet payment of " + amount);
            System.out.println("Wallet ID: " + WalletId + ", OTP: " + Otp);

    }


}
