public class Emailnotifier implements Observer{
    private  String email;
    public Emailnotifier(String email) {
        this.email = email;
    }

    @Override
    public void update(String message) {
        System.out.println("Email sent to " + email + ": " + message);
    }

}
