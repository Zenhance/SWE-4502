public class EmailNotification implements IObserver{
    private final String email;


    public EmailNotification(String email) {
        this.email = email;
    }

    public void update(String message) {
        System.out.println("Email sent to " + email + ": " + message);
    }}
