public class EmailObserver implements Observer {
    private String email;
    public EmailObserver(String email) {
        this.email = email;
    }
    @Override
    public void update(String message) {
        System.out.println("Sending email to " + email + " with message: " + message);
    }
}