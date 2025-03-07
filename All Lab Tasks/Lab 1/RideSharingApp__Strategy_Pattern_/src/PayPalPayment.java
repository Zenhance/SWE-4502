public class PayPalPayment implements IPaymentMethod
{
    private String email;
    private int otp;

    public PayPalPayment(String email, int otp) {
        this.email = email;
        this.otp = otp;
    }
    public String getEmail() {
        return email;
    }

    public int getOtp() {
        return otp;
    }
    @Override
    public void ProcessPayment(double amount) {
        System.out.println("Processing PayPal payment of " + amount);
        System.out.println("Email: " + email + ", OTP: " + otp);
    }
}

